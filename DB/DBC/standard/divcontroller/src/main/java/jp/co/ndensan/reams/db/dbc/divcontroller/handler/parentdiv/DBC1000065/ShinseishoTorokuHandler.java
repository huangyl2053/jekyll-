/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000065;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kijunshunyugakutekiyoshinseishohakkoichiran.DBC190030_KijunsyunygetsujiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.ShinseishoHakkoChushutsuJoken.ShinseishoHakkoChushutsuJoken;
import jp.co.ndensan.reams.db.dbc.definition.core.shinseishotorokuchushutsutaisho.ShinseishoTorokuChushutsuTaisho;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000065.ShinseishoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kijunshunyugaku.TekiyoShinseishoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 基準収入額適用申請書_異動分作成のハンドラクラスです。
 *
 * @reamsid_L DBC-4640-010 qinzhen
 */
public class ShinseishoTorokuHandler {

    private final ShinseishoTorokuDiv div;
    private static final int 八 = 8;
    private static final int 十二 = 12;
    private static final int INDEX_4 = 4;
    private static final int 年度 = 2015;
    private static final RString 八月一日 = new RString("0801");
    private static final RString 七月三十一日 = new RString("0731");
    private static final ReportId 帳票ID = new ReportId("DBC100064_KijunShunyugakuTekiyoShinseisho");
    private static final SubGyomuCode サブ業務コード = new SubGyomuCode("DBC");
    private static final RString 零 = new RString("0001");
    private static final RString 日 = new RString("01");
    private static final RString 本年 = new RString("本年");
    private static final RString 月中 = new RString("月中");
    private static final RString 十二月三十一 = new RString("1231");
    private static final RString 出力順を = new RString("出力順を");
    private static final RString 年次処理が未実施の = new RString("年次処理が未実施の");
    private static final RString 実行 = new RString("実行");

    /**
     * ShinseishoTorokuDiv取得します。
     *
     * @param div 画面DIV
     */
    public ShinseishoTorokuHandler(ShinseishoTorokuDiv div) {
        this.div = div;
    }

    /**
     * initialize事件ことです。
     *
     * @param div ShinseishoTorokuDiv
     */
    public void initialize(ShinseishoTorokuDiv div) {
        div.getRadChushutsuJoken().setDataSource(get申請書発行_抽出条件());
        div.getRadChushutsuTaisho().setDataSource(get申請書登録_抽出対象());
        div.getRadChushutsuJoken().setSelectedKey(零);

        set処理年度の初期値();

        FlexibleDate 世帯員把握基準日基準日 = new FlexibleDate(YMDHMS.now().getYear()
                .toDateString().concat(new RString(YMDHMS.now().getMonthValue()).padZeroToLeft(2).concat(日)));
        div.getTxtSetaiinHaakuKijunYMD().setValue(世帯員把握基準日基準日);

        RString 提出期限 = 本年.concat(new RString(YMDHMS.now().getMonthValue() + 1).concat(月中));
        div.getTxtTeishutsuKigen().setValue(提出期限);
        FlexibleDate 作成日 = new FlexibleDate(YMDHMS.now().getDate().toDateString());
        div.getTxtSakuseiYMD().setValue(作成日);

        div.getChkTsuchisho().setSelectedItems(div.getChkTsuchisho().getDataSource());
        div.getChkShinseisho().setSelectedItems(div.getChkShinseisho().getDataSource());
        div.getChkIchiranhyoCsv().setSelectedItems(div.getChkIchiranhyoCsv().getDataSource());
        div.getCcdChohyoShutsuryokujun().load(サブ業務コード, 帳票ID);
    }

    /**
     * 文書番号ccdの初期化
     *
     */
    public void set文書番号() {
        FlexibleDate 基準日 = new FlexibleDate(YMDHMS.now().getDate().toDateString());
        div.getCcdBunshoBangoInput().initialize(帳票ID, 基準日);
    }

    /**
     * 処理年度txtの初期値設定
     *
     */
    public void set処理年度の初期値() {
        if (1 <= YMDHMS.now().getMonthValue() && YMDHMS.now().getMonthValue() < 八) {
            div.getTxtShoriNendo().setValue(FlexibleDate.getNowDate().minusYear(1));
        } else if (八 <= YMDHMS.now().getMonthValue() && YMDHMS.now().getMonthValue() <= 十二) {
            div.getTxtShoriNendo().setValue(FlexibleDate.getNowDate());
        }
    }

    /**
     * 出力順の入力チェック
     *
     */
    public void set出力順の入力チェック() {
        if (div.getCcdChohyoShutsuryokujun().get出力順ID() == null) {
            throw new ApplicationException(UrErrorMessages.未指定.getMessage().replace(出力順を.toString()));
        }
    }

    /**
     * 年次処理が実行済みか確認
     *
     */
    public void 年次処理が実行済みか確認() {
        if (!年次処理が実施済みか判定()) {
            throw new ApplicationException(DbzErrorMessages.実行不可.getMessage().replace(年次処理が未実施の.toString(), 実行.toString()));
        }
    }

    /**
     * 年次処理が実施済みか判定
     *
     * @return 判定
     */
    public boolean 年次処理が実施済みか判定() {
        if (ShinseishoHakkoChushutsuJoken.異動分.getコード().equals(div.getRadChushutsuJoken().getSelectedKey())
                || ShinseishoHakkoChushutsuJoken.被保険者番号.getコード().equals(div.getRadChushutsuJoken().getSelectedKey())) {
            FlexibleYear 年度 = ShinseishoHakkoChushutsuJoken.異動分.getコード().equals(div.getRadChushutsuJoken().getSelectedKey())
                    ? div.getTxtSetaiinHaakuKijunYMD().getValue().getYear() : new FlexibleYear(div.getTxtShoriNendo().getValue().toString().substring(0, INDEX_4));
            return TekiyoShinseishoManager.createInstance().isNenjiExecute(年度);
        } else {
            return false;
        }
    }

    /**
     * バッチパラメータ
     *
     * @param div ShinseishoTorokuDiv
     * @return parameter
     */
    public DBC190030_KijunsyunygetsujiParameter setバッチ(ShinseishoTorokuDiv div) {
        DBC190030_KijunsyunygetsujiParameter parameter = new DBC190030_KijunsyunygetsujiParameter();
        FlexibleDate 世帯員把握基準日2 = new FlexibleDate(div.getTxtSetaiinHaakuKijunYMD()
                .getValue().getYear().minusYear(1).toString().concat(十二月三十一.toString()));
        parameter.set抽出対象(div.getRadChushutsuJoken().getSelectedKey());
        parameter.set抽出条件(div.getRadChushutsuJoken().getSelectedKey());
        parameter.set処理年度(new FlexibleYear(div.getTxtShoriNendo().getValue().toString().substring(0, INDEX_4)));
        if (div.getTxtHihokenshaNo().getValue() != null) {
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHihokenshaNo().getValue().toString());
            parameter.set被保険者番号(被保険者番号);
        }
        parameter.set世帯員把握基準日(div.getTxtSetaiinHaakuKijunYMD().getValue());
        parameter.set世帯員把握基準日2(世帯員把握基準日2);
        parameter.set提出期限(div.getTxtTeishutsuKigen().getValue());
        parameter.set作成日(div.getTxtSakuseiYMD().getValue());
        parameter.set申請書出力フラグ(!(div.getChkShinseisho().getSelectedKeys().isEmpty()));
        parameter.setお知らせ通知書出力フラグ(!(div.getChkShinseisho().getSelectedKeys().isEmpty()));
        parameter.set一覧表CSV出力フラグ(!(div.getChkShinseisho().getSelectedKeys().isEmpty()));
        parameter.set文書番号(div.getCcdBunshoBangoInput().get文書番号());
        parameter.set帳票出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());
        parameter.set市町村コード(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード());
        parameter.set市町村名(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
        return parameter;
    }

    /**
     * 前排他のンメソッドです。
     *
     *
     */
    public void set前排他() {
        LockingKey 前排他キー = new LockingKey(ResponseHolder.getMenuID());
        if (!RealInitialLocker.tryGetLock(前排他キー)) {
            throw new PessimisticLockingException();
        }
    }

    /**
     * 前排他のreleaseです。
     *
     *
     */
    public void release前排他() {
        LockingKey 排他キー = new LockingKey(ResponseHolder.getMenuID());
        RealInitialLocker.release(排他キー);
    }

    /**
     * 抽出条件表示制御処理
     *
     *
     */
    public void set抽出条件表示制御処理() {

        if (ShinseishoHakkoChushutsuJoken.異動分.getコード().equals(div.getRadChushutsuJoken().getSelectedKey())) {
            div.getTxtShoriNendo().setDisabled(false);
            div.getBtnSearchHihokensha().setDisabled(true);
            div.getTxtHihokenshaNo().setDisabled(true);
            div.getTxtSetaiinHaakuKijunYMD().setDisabled(false);
            div.getRadChushutsuTaisho().setDisabled(true);
        } else if (ShinseishoHakkoChushutsuJoken.被保険者番号.getコード().equals(div.getRadChushutsuJoken().getSelectedKey())) {
            div.getTxtShoriNendo().setDisabled(true);
            div.getBtnSearchHihokensha().setDisabled(false);
            div.getTxtHihokenshaNo().setDisabled(false);
            div.getTxtSetaiinHaakuKijunYMD().setDisabled(false);
            div.getRadChushutsuTaisho().setDisabled(false);
        } else {
            div.getTxtShoriNendo().setDisabled(true);
            div.getBtnSearchHihokensha().setDisabled(true);
            div.getTxtHihokenshaNo().setDisabled(true);
            div.getTxtSetaiinHaakuKijunYMD().setDisabled(true);
            div.getRadChushutsuTaisho().setDisabled(true);
        }
    }

    /**
     * 世帯員把握基準日判定
     *
     * @return boolaean
     */
    public boolean 世帯員把握基準日判定() {
        FlexibleDate 上限日程 = new FlexibleDate(div.getTxtShoriNendo()
                .getValue().toString().substring(0, INDEX_4).concat(八月一日.toString()));
        FlexibleDate 下限日程 = new FlexibleDate(
                new FlexibleYear(div.getTxtShoriNendo().getValue().toString().substring(0, INDEX_4))
                .plusYear(1).toString().concat(七月三十一日.toString()));
        return div.getTxtSetaiinHaakuKijunYMD().getValue().isBefore(上限日程)
                || 下限日程.isBefore(div.getTxtSetaiinHaakuKijunYMD().getValue());
    }

    /**
     * 処理年度判定
     *
     * @return boolaean
     */
    public boolean 処理年度判定() {
        return (Integer.valueOf(div.getTxtShoriNendo().getValue().toString().substring(0, INDEX_4)) <= 年度);
    }

    /**
     * 申請書発行_抽出条件
     *
     *
     */
    private List<KeyValueDataSource> get申請書発行_抽出条件() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShinseishoHakkoChushutsuJoken 申請書発行_抽出条件 : ShinseishoHakkoChushutsuJoken.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(申請書発行_抽出条件.getコード(), 申請書発行_抽出条件.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    /**
     * 申請書登録_抽出対象
     *
     *
     */
    private List<KeyValueDataSource> get申請書登録_抽出対象() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShinseishoTorokuChushutsuTaisho 申請書登録_抽出対象 : ShinseishoTorokuChushutsuTaisho.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(申請書登録_抽出対象.getコード(), 申請書登録_抽出対象.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

}
