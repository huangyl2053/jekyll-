var DBC;
(function (DBC) {
    (function (FukushiyoguShohinGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_Btnkennsaku = function () {
                return "onClick_Btnkennsaku";
            };

            Events.onClick_TuyikaButton = function () {
                return "onClick_TuyikaButton";
            };

            Events.onClick_Btnsenntaku = function () {
                return "onClick_Btnsenntaku";
            };

            Events.onClick_ModifyButton = function () {
                return "onClick_ModifyButton";
            };

            Events.onClick_DeleteButton = function () {
                return "onClick_DeleteButton";
            };

            Events.onClick_btnUpdate = function () {
                return "onClick_btnUpdate";
            };

            Events.onClick_btnTorikeshi = function () {
                return "onClick_btnTorikeshi";
            };
            return Events;
        })();
        FukushiyoguShohinGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "FukushiyoguShohinGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.FukushiyoguShohinGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.FukushiyoguShohinGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.FukushiyoguShohinGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKijunDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunDay"));
            };

            Controls.prototype.btnSelect = function () {
                return new UZA.Button(this.convFiledName("btnSelect"));
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgFukushiyoguShohin = function () {
                return new UZA.DataGrid(this.convFiledName("dgFukushiyoguShohin"));
            };

            Controls.prototype.panInput = function () {
                return new UZA.Panel(this.convFiledName("panInput"));
            };

            Controls.prototype.txtKanriKaishiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKanriKaishiDay"));
            };

            Controls.prototype.txtKanriShuryoDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKanriShuryoDay"));
            };

            Controls.prototype.txtShohinmei = function () {
                return new UZA.TextBox(this.convFiledName("txtShohinmei"));
            };

            Controls.prototype.txtHinmokuCode = function () {
                return new UZA.TextBox(this.convFiledName("txtHinmokuCode"));
            };

            Controls.prototype.txtSeizoJigyoshamei = function () {
                return new UZA.TextBox(this.convFiledName("txtSeizoJigyoshamei"));
            };

            Controls.prototype.btnSave = function () {
                return new UZA.Button(this.convFiledName("btnSave"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        FukushiyoguShohinGuide.Controls = Controls;
    })(DBC.FukushiyoguShohinGuide || (DBC.FukushiyoguShohinGuide = {}));
    var FukushiyoguShohinGuide = DBC.FukushiyoguShohinGuide;
})(DBC || (DBC = {}));
