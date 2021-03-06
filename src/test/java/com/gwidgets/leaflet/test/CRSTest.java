package com.gwidgets.leaflet.test;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwidgets.api.leaflet.CRS;
import com.gwidgets.api.leaflet.L;
import com.gwidgets.api.leaflet.LatLng;
import com.gwidgets.api.leaflet.Point;
import com.gwidgets.api.leaflet.elemental.Function;

public class CRSTest extends GwtyLeafletTestCase {
	
	
	public void testMapLoadEvent() {
		InjectedLeafletResources.whenReady(new Function() {
			public JavaScriptObject call(JavaScriptObject event) {
				CRS myCRS = L.CRS.EPSG3857;
				
				Point p = myCRS.project(L.latLng(52.12, 42.15));
				
				LatLng unprojected = myCRS.unproject(p);
						
				assertEquals(unprojected.lat.toString().substring(0, 5), "52.12");
				assertEquals(unprojected.lng.toString().substring(0, 5), "42.15");
				
				double scaled = myCRS.scale(25);
				double zoomed = myCRS.zoom(scaled);
				
				
				assertEquals(String.valueOf(zoomed), "25");
				
				return null;
			}
		});
	}

}
