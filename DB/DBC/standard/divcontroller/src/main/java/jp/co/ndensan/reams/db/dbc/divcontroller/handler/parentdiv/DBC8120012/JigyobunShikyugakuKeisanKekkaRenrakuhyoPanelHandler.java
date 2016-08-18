/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8120012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120012.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.jigyobunshikyugakukeisankekkarenrakuhyopanel.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 事業高額合算・事業分支給額計算結果連絡票（単）のHandlerクラスです。
 *
 * @reamsid_L DBC-4840-010 lihang
 */
public class JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelHandler {

    private final JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div;
    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private static final RString 発行する = new RString("btnPrint");

    /**
     * コンストラクタです。
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     */
    public JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelHandler(JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv div) {
        this.div = div;
    }

    /**
     * initializeをします。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param parameter
     * JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter
     *
     * @throws PessimisticLockingException
     * @throws ApplicationException
     */
    public void initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter parameter) {
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            throw new ApplicationException(DbcInformationMessages.被保険者でないデータ.getMessage());
        } else {
            if (!get前排他(被保険者番号.getColumnValue())) {
                コントロールの非活性化();
                throw new PessimisticLockingException();
            }
            CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, false);
            div.getCclKaigoAtenaInfo().initialize(識別コード);
            被保険者番号存在チェック(被保険者番号);
            div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
            ドロップダウンリスト項目と前回作成日TXTセット(parameter);
        }
    }

    /**
     * 対象年度DDLをチェンジします
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void onChange対象年度DDL(HihokenshaNo 被保険者番号) {
        div.getDdlShoKisaiHokenshaNo().getDataSource().clear();
        div.getDdlShikyuShinseishoSeiriNo().getDataSource().clear();
        div.getSakuseiPanel().getTxtZenkaiSakuseiYMD().clearValue();
        JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter parameter
                = setJigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter(被保険者番号,
                        new FlexibleYear(div.getDdlTaishoNendo().getSelectedKey()), null, null);
        List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult> renrakuhyoPanelList = 対象データ取得(parameter);
        List<KeyValueDataSource> shoKisaiHokenshaNodataSource = new ArrayList();
        List<KeyValueDataSource> shikyuShinseishoSeiriNodataSource = new ArrayList();
        if (!renrakuhyoPanelList.isEmpty()) {
            for (JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult renrakuhyoPanel : renrakuhyoPanelList) {
                if (!(shoKisaiHokenshaNodataSource.contains(new KeyValueDataSource(
                        renrakuhyoPanel.getEntity().getShoKisaiHokenshaNo().getColumnValue(),
                        renrakuhyoPanel.getEntity().getShoKisaiHokenshaNo().getColumnValue())))) {
                    shoKisaiHokenshaNodataSource.add(new KeyValueDataSource(
                            renrakuhyoPanel.getEntity().getShoKisaiHokenshaNo().getColumnValue(),
                            renrakuhyoPanel.getEntity().getShoKisaiHokenshaNo().getColumnValue()));
                }
                if (!(shikyuShinseishoSeiriNodataSource.contains(new KeyValueDataSource(
                        renrakuhyoPanel.getEntity().getShikyuShinseishoSeiriNo(),
                        renrakuhyoPanel.getEntity().getShikyuShinseishoSeiriNo())))) {
                    shikyuShinseishoSeiriNodataSource.add(new KeyValueDataSource(
                            renrakuhyoPanel.getEntity().getShikyuShinseishoSeiriNo(),
                            renrakuhyoPanel.getEntity().getShikyuShinseishoSeiriNo()));
                }
            }
            div.getDdlShoKisaiHokenshaNo().setDataSource(shoKisaiHokenshaNodataSource);
            div.getDdlShoKisaiHokenshaNo().setSelectedIndex(0);
            div.getDdlShikyuShinseishoSeiriNo().setDataSource(shikyuShinseishoSeiriNodataSource);
            div.getDdlShikyuShinseishoSeiriNo().setSelectedIndex(0);
            onChange連絡票整理番号DDL(被保険者番号);
        }
    }

    /**
     * 連絡票整理番号DDLをチェンジします
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void onChange連絡票整理番号DDL(HihokenshaNo 被保険者番号) {
        div.getDdlShoKisaiHokenshaNo().getDataSource().clear();
        div.getSakuseiPanel().getTxtZenkaiSakuseiYMD().clearValue();
        JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter parameter
                = setJigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter(被保険者番号,
                        new FlexibleYear(div.getDdlTaishoNendo().getSelectedKey()),
                        div.getDdlShikyuShinseishoSeiriNo().getSelectedValue(),
                        null);
        List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult> renrakuhyoPanelList = 対象データ取得(parameter);
        List<KeyValueDataSource> shoKisaiHokenshaNodataSource = new ArrayList();
        if (!renrakuhyoPanelList.isEmpty()) {
            for (JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult renrakuhyoPanel : renrakuhyoPanelList) {
                if (!(shoKisaiHokenshaNodataSource.contains(new KeyValueDataSource(
                        renrakuhyoPanel.getEntity().getShoKisaiHokenshaNo().getColumnValue(),
                        renrakuhyoPanel.getEntity().getShoKisaiHokenshaNo().getColumnValue())))) {
                    shoKisaiHokenshaNodataSource.add(new KeyValueDataSource(
                            renrakuhyoPanel.getEntity().getShoKisaiHokenshaNo().getColumnValue(),
                            renrakuhyoPanel.getEntity().getShoKisaiHokenshaNo().getColumnValue()));
                }
            }
            div.getDdlShoKisaiHokenshaNo().setDataSource(shoKisaiHokenshaNodataSource);
            div.getDdlShoKisaiHokenshaNo().setSelectedIndex(0);
            onChange証記載保険者番号DDL(被保険者番号);
        }
    }

    /**
     * 証記載保険者番号DDLをチェンジします。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void onChange証記載保険者番号DDL(HihokenshaNo 被保険者番号) {
        div.getSakuseiPanel().getTxtZenkaiSakuseiYMD().clearValue();
        JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter parameter
                = setJigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter(被保険者番号,
                        new FlexibleYear(div.getDdlTaishoNendo().getSelectedKey()),
                        div.getDdlShikyuShinseishoSeiriNo().getSelectedValue(),
                        new HokenshaNo(div.getDdlShoKisaiHokenshaNo().getSelectedValue()));
        List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult> renrakuhyoPanelList = 対象データ取得(parameter);
        if (!renrakuhyoPanelList.isEmpty() && renrakuhyoPanelList.get(0).getEntity().getSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD() != null) {
            div.getTxtZenkaiSakuseiYMD().setValue(
                    renrakuhyoPanelList.get(0).getEntity().getSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD());
        }
    }

    /**
     * 発行します
     *
     * @param 被保険者番号 HihokenshaNo
     * @return JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelBatchParameter
     */
    public JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelBatchParameter onClick発行する(HihokenshaNo 被保険者番号) {

        前排他キーの解除(被保険者番号.getColumnValue());
        JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelBatchParameter parameter
                = new JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelBatchParameter();
        parameter.setSyoridate(RDate.getNowDate().toDateString());
        parameter.setHihokenshaNo(被保険者番号);
        parameter.setTaisyonenndo(new KeyValueDataSource(div.getDdlTaishoNendo().getSelectedKey(),
                div.getDdlTaishoNendo().getSelectedValue()));
        parameter.setShikyuShinseishoSeiriNo(new KeyValueDataSource(div.getDdlShikyuShinseishoSeiriNo().getSelectedKey(),
                div.getDdlShikyuShinseishoSeiriNo().getSelectedValue()));
        parameter.setShoKisaiHokenshaNo(new KeyValueDataSource(div.getDdlShoKisaiHokenshaNo().getSelectedKey(),
                div.getDdlShoKisaiHokenshaNo().getSelectedValue()));
        return parameter;
    }

    /**
     * ドロップダウンリスト項目をセットし、前回作成日TXTをセットします
     *
     * @param parameter
     * JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter
     */
    public void ドロップダウンリスト項目と前回作成日TXTセット(JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter parameter) {
        List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult> renrakuhyoPanelList = 対象データ取得(parameter);
        if (!renrakuhyoPanelList.isEmpty()) {
            List<KeyValueDataSource> taishoNendodataSource = new ArrayList();
            for (JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult renrakuhyoPanel : renrakuhyoPanelList) {

                if (!(taishoNendodataSource.contains(new KeyValueDataSource(
                        new RString(renrakuhyoPanel.getEntity().getTaishoNendo().getYearValue()),
                        renrakuhyoPanel.getEntity().getTaishoNendo().wareki().getYear())))) {
                    taishoNendodataSource.add(new KeyValueDataSource(
                            new RString(renrakuhyoPanel.getEntity().getTaishoNendo().getYearValue()),
                            renrakuhyoPanel.getEntity().getTaishoNendo().wareki().getYear()));
                }

            }
            div.getDdlTaishoNendo().setDataSource(taishoNendodataSource);
            div.getDdlTaishoNendo().setSelectedIndex(0);
            onChange対象年度DDL(parameter.get被保険者番号());
            div.getTxtSakuseiYMD().setValue(FlexibleDate.getNowDate());
        }
    }

    /**
     * 被保険者番号存在をチェックします
     *
     * @param 被保険者番号 HihokenshaNo
     *
     * @throws ApplicationException
     */
    public void 被保険者番号存在チェック(HihokenshaNo 被保険者番号) {
        JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelFinder finder
                = JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelFinder.createInstance();
        if (finder.hihokenshaNoCheck(被保険者番号)) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
    }

    /**
     * JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameterをセットします
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 連絡票整理番号 RString
     * @param 証記載保険者番号 HokenshaNo
     * @return JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter
     */
    public JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter setJigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter(
            HihokenshaNo 被保険者番号, FlexibleYear 対象年度, RString 連絡票整理番号, HokenshaNo 証記載保険者番号) {
        JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter parameter
                = new JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter(
                        被保険者番号, 対象年度, 連絡票整理番号, 証記載保険者番号);
        return parameter;
    }

    /**
     * 対象データを取得します
     *
     * @param parameter
     * JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter
     * @return List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult>
     */
    public List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult> 対象データ取得(JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter parameter) {
        JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelFinder finder
                = JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelFinder.createInstance();
        return finder.getJigyobunShikyugakuKeisanKekkaRenrakuhyoPanelList(parameter);
    }

    /**
     * コントロールを非活性化にさせます
     *
     */
    public void コントロールの非活性化() {
        div.getCcdKaigoShikakuKihon().set被保履歴ボタンDisable(true);
        div.getCcdKaigoShikakuKihon().set認定履歴ボタンDisable(true);
    }

    /**
     * 前排他キーをセットします
     *
     * @param 被保険者番号 RString
     */
    public void 前排他キーのセット(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        RealInitialLocker.lock(排他キー);
    }

    /**
     * 前排他を取得します
     *
     * @param 被保険者番号 RString
     * @return boolean
     */
    public boolean get前排他(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他キーを解除します
     *
     * @param 被保険者番号 RString
     */
    public void 前排他キーの解除(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        RealInitialLocker.release(排他キー);
    }
}
