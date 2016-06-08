var DBC;
(function (DBC) {
    (function (KyufuKanrihyoInfo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KyufuKanrihyoInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KyufuKanrihyoInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KyufuKanrihyoInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KyufuKanrihyoInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KyufuKanrihyoInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtSakuseiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtSakuseiKubun"));
            };

            Controls.prototype.txtSakuseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSakuseiYMD"));
            };

            Controls.prototype.txtZengetsuNissu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtZengetsuNissu"));
            };

            Controls.prototype.txtKeikakuSakuseiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKeikakuSakuseiKubun"));
            };

            Controls.prototype.txtShienJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShienJigyoshaNo"));
            };

            Controls.prototype.txtShienJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShienJigyoshaName"));
            };

            Controls.prototype.txtShikyuGendogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuGendogaku"));
            };

            Controls.prototype.txtGendogakuTekiyoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtGendogakuTekiyoKikan"));
            };

            Controls.prototype.txtShiteiServiceShokei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShiteiServiceShokei"));
            };

            Controls.prototype.txtKijunServiceShokei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKijunServiceShokei"));
            };

            Controls.prototype.txtGokeiTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGokeiTanisu"));
            };

            Controls.prototype.dgMeisaiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgMeisaiList"));
            };

            Controls.prototype.txtTantoSenmonNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtTantoSenmonNo"));
            };

            Controls.prototype.txtItakuJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtItakuJigyoshaNo"));
            };

            Controls.prototype.txtItakuJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtItakuJigyoshaName"));
            };

            Controls.prototype.txtItakuSenmonNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtItakuSenmonNo"));
            };
            return Controls;
        })();
        KyufuKanrihyoInfo.Controls = Controls;
    })(DBC.KyufuKanrihyoInfo || (DBC.KyufuKanrihyoInfo = {}));
    var KyufuKanrihyoInfo = DBC.KyufuKanrihyoInfo;
})(DBC || (DBC = {}));
