var DBZ;
(function (DBZ) {
    (function (ShisetsuJohoCommonChildDiv) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_daichoShubetsu = function () {
                return "onChange_daichoShubetsu";
            };

            Events.onBlur_nyuryokuShisetsuKodo = function () {
                return "onBlur_nyuryokuShisetsuKodo";
            };

            Events.onChange_nyuryokuShisetsuKodo = function () {
                return "onChange_nyuryokuShisetsuKodo";
            };

            Events.onOkClose_btnSenTaKu = function () {
                return "onOkClose_btnSenTaKu";
            };

            Events.onBeforeOpenDialog_shisetsu = function () {
                return "onBeforeOpenDialog_shisetsu";
            };
            return Events;
        })();
        ShisetsuJohoCommonChildDiv.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuJohoCommonChildDiv";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShisetsuJohoCommonChildDiv.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShisetsuJohoCommonChildDiv.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuJohoCommonChildDiv = function () {
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
        ShisetsuJohoCommonChildDiv.Controls = Controls;
    })(DBZ.ShisetsuJohoCommonChildDiv || (DBZ.ShisetsuJohoCommonChildDiv = {}));
    var ShisetsuJohoCommonChildDiv = DBZ.ShisetsuJohoCommonChildDiv;
})(DBZ || (DBZ = {}));
