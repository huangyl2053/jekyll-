var DBA;
(function (DBA) {
    (function (ServiceCodeCommonChildDiv) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_Kensaku = function () {
                return "onClick_Kensaku";
            };

            Events.onClick_btnYameru = function () {
                return "onClick_btnYameru";
            };

            Events.onClick_btnKakutei = function () {
                return "onClick_btnKakutei";
            };
            return Events;
        })();
        ServiceCodeCommonChildDiv.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceCodeCommonChildDiv";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.ServiceCodeCommonChildDiv.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.ServiceCodeCommonChildDiv.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceCodeCommonChildDiv = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtServiceCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode"));
            };

            Controls.prototype.txtKomokuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKomokuCode"));
            };

            Controls.prototype.txtKijunYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunYM"));
            };

            Controls.prototype.btnServiceCodeKensaku = function () {
                return new UZA.Button(this.convFiledName("btnServiceCodeKensaku"));
            };

            Controls.prototype.dgCodeIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgCodeIchiran"));
            };

            Controls.prototype.btnYameru = function () {
                return new UZA.Button(this.convFiledName("btnYameru"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        ServiceCodeCommonChildDiv.Controls = Controls;
    })(DBA.ServiceCodeCommonChildDiv || (DBA.ServiceCodeCommonChildDiv = {}));
    var ServiceCodeCommonChildDiv = DBA.ServiceCodeCommonChildDiv;
})(DBA || (DBA = {}));
