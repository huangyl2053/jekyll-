/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210011.TsukibetsuSuiihyoSakuseiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 月別推移表のHandlerクラスです。
 *
 * @reamsid_L DBB-0760-010 zhangguopeng
 */
public class TsukibetsuSuiihyoSakuseiHandler {

    private final TsukibetsuSuiihyoSakuseiDiv div;
    private static final RString SHICHOSONCODE_220 = new RString("220");
    private static final RString SHICHOSONCODE_111 = new RString("111");
    private static final RString SHICHOSONCODE_112 = new RString("112");
    private static final RString 年齢 = new RString("nenrei");
    private static final RString 生年月日 = new RString("umareYMD");
    private static final RString 空白文字 = new RString("");

    /**
     * コンストラクタです。
     *
     * @param div 月別推移表のクラスファイル
     */
    public TsukibetsuSuiihyoSakuseiHandler(TsukibetsuSuiihyoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onload() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null) {
            Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
            if (new Code(SHICHOSONCODE_111).equals(導入形態コード)) {
                // 状態１　初期化状態（広域保険者）
                setヘッダエリア();
                set抽出条件エリア();
                // 市町村==全市町村
            } else if (new Code(SHICHOSONCODE_112).equals(導入形態コード)
                    || new Code(SHICHOSONCODE_220).equals(導入形態コード)) {
                // 状態２　初期化状態（単一保険者）
                setヘッダエリア();
                set抽出条件エリア();
//            div.getCcdChikuShichosonSelect().
                // 選択対象==全て
            }
        }
    }

    /**
     * 条件を復元するボタンを押下する場合、バッチパラメータの設定値を画面に表示する。
     */
    public void onClick_btnKogakuParamRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnParameterRestore().getRestoreBatchParameterMap();
        RString 調定年度 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("ddlChoteiNendo"));
        div.getDdlChoteiNendo().setSelectedKey(調定年度);
        RDate 調定基準日 = restoreBatchParameterMap.getParameterValue(RDate.class, new RString("txtChoteiKijunYMD"));
        div.getTxtChoteiKijunYMD().setValue(調定基準日);
        RString 各月資格基準日 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("ddShikakuKijunD"));
        div.getDdShikakuKijunD().setSelectedKey(各月資格基準日);
        boolean is年齢 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("radNenrei"));
        if (is年齢) {
            div.getRadNenrei().setSelectedKey(年齢);
        }
        boolean is生年月日 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("radUmareYMD"));
        if (is生年月日) {
            div.getRadUmareYMD().setSelectedKey(生年月日);
        }
        Decimal 年齢開始 = restoreBatchParameterMap.getParameterValue(Decimal.class, new RString("txtNenreiSt"));
        div.getTxtNenreiSt().setValue(年齢開始);
        Decimal 年齢終了 = restoreBatchParameterMap.getParameterValue(Decimal.class, new RString("txtNenreiEd"));
        div.getTxtNenreiEd().setValue(年齢終了);
        RDate 年齢基準日 = restoreBatchParameterMap.getParameterValue(RDate.class, new RString("txtNenreiKijunYMD"));
        div.getTxtNenreiKijunYMD().setValue(年齢基準日);
        RDate 生年月日開始 = restoreBatchParameterMap.getParameterValue(RDate.class, new RString("txtUmareSt"));
        div.getTxtUmareSt().setValue(生年月日開始);
        RDate 生年月日終了 = restoreBatchParameterMap.getParameterValue(RDate.class, new RString("txtUmareEd"));
        div.getTxtUmareEd().setValue(生年月日終了);
        // TODO 介護地区・市町村選択DIVに項目設定無し、技術点NO.65
    }

    /**
     * バッチパラメータを作成します。
     *
     * @return CreateTsukibetsuSuiihyoBatchParameter 月別推移表作成_バッチ用のパラメータ
     */
    public CreateTsukibetsuSuiihyoBatchParameter batchParameter() {

        FlexibleYear 調定年度 = new FlexibleYear(div.getDdlChoteiNendo().getSelectedValue());
        RStringBuilder 調定基準日 = new RStringBuilder();
        調定基準日.append(div.getTxtChoteiKijunYMD().getValue());
        調定基準日.append(RDate.getNowDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        boolean is年齢 = false;
        boolean is生年月日 = false;
        if (年齢.equals(div.getRadNenrei().getSelectedKey())) {
            is年齢 = true;
        }
        if (生年月日.equals(div.getRadUmareYMD().getSelectedKey())) {
            is生年月日 = true;
        }
        // TODO 介護地区・市町村選択共有子Divを呼び出す
        return new CreateTsukibetsuSuiihyoBatchParameter(調定年度, 調定基準日.toRString(), div.getDdShikakuKijunD().getSelectedKey(), is年齢, nullToEmpty(div.getTxtNenreiSt().getValue()),
                nullToEmpty(div.getTxtNenreiSt().getValue()), nullToEmpty(div.getTxtNenreiKijunYMD().getValue()), is生年月日,
                nullToEmpt(div.getTxtUmareSt().getValue()), nullToEmpt(div.getTxtUmareEd().getValue()),
                RString.EMPTY, null, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    private RString nullToEmpty(Decimal 年齢) {
        if (年齢 != null) {
            return new RString(年齢.toString());
        }
        return RString.EMPTY;
    }

    private FlexibleDate nullToEmpty(RDate 日期) {
        if (日期 != null) {
            return new FlexibleDate(日期.toDateString());
        }
        return FlexibleDate.EMPTY;
    }

    private RString nullToEmpt(RDate 日期) {
        if (日期 != null) {
            return 日期.toDateString();
        }
        return RString.EMPTY;
    }

    private void setヘッダエリア() {
        div.getDdlChoteiNendo().setSelectedValue((BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課)));
        div.getTxtChoteiKijunYMD().setValue(RDate.getNowDate());
    }

    private void set抽出条件エリア() {
        set各月資格基準日();
        div.getRadNenrei().setSelectedKey(年齢);
        div.getTxtUmareSt().setDisabled(true);
        div.getTxtUmareEd().setDisabled(true);

    }

    private void set各月資格基準日() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (int i = 1; i < RDate.getNowDate().getLastDay(); i++) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString(空白文字.toString() + i));
            dataSource.setValue(new RString(空白文字.toString() + i));
            dataSourceList.add(dataSource);
        }
        div.getDdShikakuKijunD().setDataSource(dataSourceList);
        for (int i = 1; i < RDate.getNowDate().getLastDay(); i++) {
            if (i == RDate.getNowDate().getDayValue()) {
                div.getDdShikakuKijunD().setSelectedKey(new RString(空白文字.toString() + i));
            }
        }

    }
}
