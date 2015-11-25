var DBZ;
(function (DBZ) {
    (function (shisetsuJohoCommonChildDiv) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        shisetsuJohoCommonChildDiv.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "shisetsuJohoCommonChildDiv";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.shisetsuJohoCommonChildDiv.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.shisetsuJohoCommonChildDiv.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.shisetsuJohoCommonChildDiv = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlDaichoShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlDaichoShubetsu"));
            };

            Controls.prototype.radKaigoHokenShisetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radKaigoHokenShisetsu"));
            };

            Controls.prototype.radOtherTokureiShisetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radOtherTokureiShisetsu"));
            };

            Controls.prototype.radTekiyoJyogaiShisetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radTekiyoJyogaiShisetsu"));
            };

            Controls.prototype.txtNyuryokuShisetsuKodo = function () {
                return new UZA.TextBox(this.convFiledName("txtNyuryokuShisetsuKodo"));
            };

            Controls.prototype.btnJigyoshaKensaku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaKensaku"));
            };

            Controls.prototype.txtNyuryokuShisetsuMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtNyuryokuShisetsuMeisho"));
            };
            return Controls;
        })();
        shisetsuJohoCommonChildDiv.Controls = Controls;
    })(DBZ.shisetsuJohoCommonChildDiv || (DBZ.shisetsuJohoCommonChildDiv = {}));
    var shisetsuJohoCommonChildDiv = DBZ.shisetsuJohoCommonChildDiv;
})(DBZ || (DBZ = {}));
