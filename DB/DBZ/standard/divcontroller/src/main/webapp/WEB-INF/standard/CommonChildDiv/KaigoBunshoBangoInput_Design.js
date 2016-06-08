var DBZ;
(function (DBZ) {
    (function (KaigoBunshoBangoInput) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoBunshoBangoInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoBunshoBangoInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoBunshoBangoInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoBunshoBangoInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoBunshoBangoInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtBunshoShurui = function () {
                return new UZA.TextBox(this.convFiledName("txtBunshoShurui"));
            };

            Controls.prototype.txtBunshoHeader = function () {
                return new UZA.TextBox(this.convFiledName("txtBunshoHeader"));
            };

            Controls.prototype.txtBunshoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtBunshoNo"));
            };

            Controls.prototype.BunshoFoot = function () {
                return new UZA.TextBox(this.convFiledName("BunshoFoot"));
            };

            Controls.prototype.btnBunshoNoGet = function () {
                return new UZA.Button(this.convFiledName("btnBunshoNoGet"));
            };
            return Controls;
        })();
        KaigoBunshoBangoInput.Controls = Controls;
    })(DBZ.KaigoBunshoBangoInput || (DBZ.KaigoBunshoBangoInput = {}));
    var KaigoBunshoBangoInput = DBZ.KaigoBunshoBangoInput;
})(DBZ || (DBZ = {}));
