var DBC;
(function (DBC) {
    (function (KogakuKyufuTaishoList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnTsuika = function () {
                return "onClick_btnTsuika";
            };

            Events.onClick_modify = function () {
                return "onClick_modify";
            };

            Events.onClick_delete = function () {
                return "onClick_delete";
            };

            Events.onMulti_dgKyufuJissekiMeisaiList = function () {
                return "onMulti_dgKyufuJissekiMeisaiList";
            };

            Events.onOkClose_btnJgyosha = function () {
                return "onOkClose_btnJgyosha";
            };

            Events.onBeforeOpenDialog_btnJgyosha = function () {
                return "onBeforeOpenDialog_btnJgyosha";
            };

            Events.onOkClose_btnServiceSyurui = function () {
                return "onOkClose_btnServiceSyurui";
            };

            Events.onBeforeOpenDialog_btnServiceSyurui = function () {
                return "onBeforeOpenDialog_btnServiceSyurui";
            };

            Events.onClick_btnTorikeshi = function () {
                return "onClick_btnTorikeshi";
            };

            Events.onClick_btnkakutei = function () {
                return "onClick_btnkakutei";
            };
            return Events;
        })();
        KogakuKyufuTaishoList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KogakuKyufuTaishoList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KogakuKyufuTaishoList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KogakuKyufuTaishoList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KogakuKyufuTaishoList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnTsuika = function () {
                return new UZA.Button(this.convFiledName("btnTsuika"));
            };

            Controls.prototype.dgTaishoshaIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgTaishoshaIchiran"));
            };

            Controls.prototype.MeisaiGokeiHenshuPanel = function () {
                return new UZA.Panel(this.convFiledName("MeisaiGokeiHenshuPanel"));
            };

            Controls.prototype.rdbMisaiGkeiKbun = function () {
                return new UZA.RadioButton(this.convFiledName("rdbMisaiGkeiKbun"));
            };

            Controls.prototype.txtJgyoshaCode = function () {
                return new UZA.TextBox(this.convFiledName("txtJgyoshaCode"));
            };

            Controls.prototype.btnJgyosha = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJgyosha"));
            };

            Controls.prototype.txtJgyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtJgyoshaName"));
            };

            Controls.prototype.txtServiceSyurui = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceSyurui"));
            };

            Controls.prototype.btnServiceSyurui = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnServiceSyurui"));
            };

            Controls.prototype.txtServiceSyuruiName = function () {
                return new UZA.TextBox(this.convFiledName("txtServiceSyuruiName"));
            };

            Controls.prototype.txtHyoGkei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHyoGkei"));
            };

            Controls.prototype.txtRiyoshafutanGokei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshafutanGokei"));
            };

            Controls.prototype.GokeiPanel = function () {
                return new UZA.Panel(this.convFiledName("GokeiPanel"));
            };

            Controls.prototype.txtSanteiKijunGaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSanteiKijunGaku"));
            };

            Controls.prototype.txtSiharaiZumiGaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSiharaiZumiGaku"));
            };

            Controls.prototype.txtKogakuShikyuGaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuShikyuGaku"));
            };

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.KogakuKyufuKonkyoPanel = function () {
                return new UZA.Panel(this.convFiledName("KogakuKyufuKonkyoPanel"));
            };

            Controls.prototype.rdbTsukiOkure = function () {
                return new UZA.RadioButton(this.convFiledName("rdbTsukiOkure"));
            };

            Controls.prototype.rabSetaiShotokuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("rabSetaiShotokuKubun"));
            };

            Controls.prototype.rdbShotokuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("rdbShotokuKubun"));
            };

            Controls.prototype.rdbGassan = function () {
                return new UZA.RadioButton(this.convFiledName("rdbGassan"));
            };

            Controls.prototype.rdbRoreiFukushiNenkin = function () {
                return new UZA.RadioButton(this.convFiledName("rdbRoreiFukushiNenkin"));
            };

            Controls.prototype.rdbRiyoshafutanDai2dankai = function () {
                return new UZA.RadioButton(this.convFiledName("rdbRiyoshafutanDai2dankai"));
            };

            Controls.prototype.rdbGekihenkanwaKubun = function () {
                return new UZA.RadioButton(this.convFiledName("rdbGekihenkanwaKubun"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            };

            Controls.prototype.btnkakutei = function () {
                return new UZA.Button(this.convFiledName("btnkakutei"));
            };

            Controls.prototype.rowId = function () {
                return new UZA.TextBoxNum(this.convFiledName("rowId"));
            };
            return Controls;
        })();
        KogakuKyufuTaishoList.Controls = Controls;
    })(DBC.KogakuKyufuTaishoList || (DBC.KogakuKyufuTaishoList = {}));
    var KogakuKyufuTaishoList = DBC.KogakuKyufuTaishoList;
})(DBC || (DBC = {}));
