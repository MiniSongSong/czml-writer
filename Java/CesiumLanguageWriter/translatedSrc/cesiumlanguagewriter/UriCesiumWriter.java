package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumResource;
import java.awt.image.RenderedImage;

/**
 *  
 Writes a <code>Uri</code> to a  {@link CesiumOutputStream}.  A <code>Uri</code> a URI value.  The URI can optionally vary with time.
 

 */
public class UriCesiumWriter extends CesiumPropertyWriter<UriCesiumWriter> {
	/**
	 *  
	The name of the <code>uri</code> property.
	

	 */
	public static final String UriPropertyName = "uri";
	private Lazy<ICesiumValuePropertyWriter<CesiumResource>> m_asUri;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public UriCesiumWriter(String propertyName) {
		super(propertyName);
		m_asUri = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(this,
				"createUriAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource> invoke() {
				return createUriAdaptor();
			}
		}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected UriCesiumWriter(UriCesiumWriter existingInstance) {
		super(existingInstance);
		m_asUri = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(this,
				"createUriAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource> invoke() {
				return createUriAdaptor();
			}
		}, false);
	}

	@Override
	public UriCesiumWriter clone() {
		return new UriCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URI value.
	
	

	 * @param resource A resource object describing external data.
	 */
	public final void writeUri(CesiumResource resource) {
		writeUri(resource.getUrl(), resource.getBehavior());
	}

	/**
	 *  
	Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URI value.
	
	
	

	 * @param url The URL of the data.
	 * @param resourceBehavior An enumeration describing how to include the URL in the document. For even more control, use the overload that takes a ICesiumUrlResolver.
	 */
	public final void writeUri(String url, CesiumResourceBehavior resourceBehavior) {
		String PropertyName = UriPropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.getResourceUrl(url, resourceBehavior));
	}

	/**
	 *  
	Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URI value.
	
	
	

	 * @param url The URL of the data.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.
	 * @param resolver An ICesiumUrlResolver used to build the final URL that will be embedded in the document.
	 */
	public final void writeUri(String url, ICesiumUrlResolver resolver) {
		String PropertyName = UriPropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(resolver.resolveUrl(url));
	}

	/**
	 *  
	Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URI value.
	
	

	 * @param image The image.  A data URI will be created for this image, using PNG encoding.
	 */
	public final void writeUri(RenderedImage image) {
		writeUri(image, CesiumImageFormat.PNG);
	}

	/**
	 *  
	Writes the <code>uri</code> property.  The <code>uri</code> property specifies the URI value.
	
	
	

	 * @param image The image.  A data URI will be created for this image.
	 * @param imageFormat The image format to use to encode the image in the data URI.
	 */
	public final void writeUri(RenderedImage image, CesiumImageFormat imageFormat) {
		String PropertyName = UriPropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.imageToDataUri(image, imageFormat));
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Uri</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumResource> asUri() {
		return m_asUri.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumResource> createUriAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.UriCesiumWriter, cesiumlanguagewriter.CesiumResource>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.UriCesiumWriter, cesiumlanguagewriter.CesiumResource>() {
					public void invoke(UriCesiumWriter me, CesiumResource value) {
						me.writeUri(value);
					}
				});
	}
}