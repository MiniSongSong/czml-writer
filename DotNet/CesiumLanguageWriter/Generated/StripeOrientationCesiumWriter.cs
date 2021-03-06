// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>StripeOrientation</code> to a <see cref="CesiumOutputStream" />.  A <code>StripeOrientation</code> defines the orientation of stripes in the stripe material.
    /// </summary>
    public class StripeOrientationCesiumWriter : CesiumPropertyWriter<StripeOrientationCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>StripeOrientation</code> property.
        /// </summary>
        public const string StripeOrientationPropertyName = "StripeOrientation";

        private readonly Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>> m_asStripeOrientation;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public StripeOrientationCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asStripeOrientation = new Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>>(CreateStripeOrientationAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected StripeOrientationCesiumWriter(StripeOrientationCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asStripeOrientation = new Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>>(CreateStripeOrientationAdaptor, false);
        }

        /// <inheritdoc />
        public override StripeOrientationCesiumWriter Clone()
        {
            return new StripeOrientationCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>StripeOrientation</code> property.  The <code>StripeOrientation</code> property specifies the orientation of stripes in the stripe material. Valid values are "HORIZONTAL" or "VERTICAL".
        /// </summary>
        /// <param name="value">The orientation.</param>
        public void WriteStripeOrientation(CesiumStripeOrientation value)
        {
            const string PropertyName = StripeOrientationPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.StripeOrientationToString(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>StripeOrientation</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumStripeOrientation> AsStripeOrientation()
        {
            return m_asStripeOrientation.Value;
        }

        private ICesiumValuePropertyWriter<CesiumStripeOrientation> CreateStripeOrientationAdaptor()
        {
            return new CesiumWriterAdaptor<StripeOrientationCesiumWriter, CesiumStripeOrientation>(
                this, (me, value) => me.WriteStripeOrientation(value));
        }

    }
}
