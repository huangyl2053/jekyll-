/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.dgMiwaritsukeShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.dgWaritsukeZumiShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbz.service.core.sakuseiryoSeikyuKubun.SakuseiryoSeikyuKubunFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 主治医意見書作成依頼のHandlerクラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class ShujiiIkenshoSakuseiIraiHandler {

    private static final RString 未割付 = new RString("未割付");
    private static final RString 割付解除 = new RString("割付解除");
    private final ShujiiIkenshoSakuseiIraiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShujiiIkenshoSakuseiIraiDiv
     */
    public ShujiiIkenshoSakuseiIraiHandler(ShujiiIkenshoSakuseiIraiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期設定します。
     */
    public void load() {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getCcdShujiiIryoKikanAndShujiiInput().clear();
        div.getSearch().getBtnClearKensakuJoken().setDisplayNone(true);
    }

    /**
     * 割付済み申請者一覧Gridに検索結果を設定します。
     *
     * @param 割付済み申請者List 割付済み申請者一覧検索結果
     * @param hokenshaName 保険者名称
     */
    public void set割付済み申請者一覧(List<WaritsukeBusiness> 割付済み申請者List, RString hokenshaName) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> dataSource = new ArrayList<>();
        for (WaritsukeBusiness 割付済み申請者 : 割付済み申請者List) {
            dgWaritsukeZumiShinseishaIchiran_Row row = new dgWaritsukeZumiShinseishaIchiran_Row();
            row.setJotai(RString.EMPTY);
            row.setHihokenshaNo(nullToEmpty(割付済み申請者.getHihokenshaNo()));
            row.setHihokenshaShimei(割付済み申請者.getHihokenshaName() == null ? RString.EMPTY : 割付済み申請者.getHihokenshaName().value());
            if (割付済み申請者.getSeibetsu() != null && !RString.isNullOrEmpty(割付済み申請者.getSeibetsu().value())) {
                row.setSeibetsu(Seibetsu.toValue(割付済み申請者.getSeibetsu().value()).get名称());
            }
            setNinteiShinseiJoho(割付済み申請者, row);
            if (割付済み申請者.getChikuCode() != null) {
                RString codeName = CodeMaster.getCodeMeisho(
                        SubGyomuCode.DBE認定支援,
                        DBECodeShubetsu.調査地区コード.getコード(),
                        new Code(割付済み申請者.getChikuCode().value()),
                        FlexibleDate.getNowDate());
                if (codeName != null) {
                    row.setChiku(codeName);
                }
            }
            row.setZenkaiChosaItakusaki(nullToEmpty(割付済み申請者.getTemp_jigyoshaMeisho()));
            row.setZenkaiChosain(nullToEmpty(割付済み申請者.getTemp_chosainShimei()));

            if (割付済み申請者.getIkenshoSakuseiIraiYMD() != null && !割付済み申請者.getIkenshoSakuseiIraiYMD().isEmpty()) {
                row.setIkenshoSakuseiIraiDay(割付済み申請者.getIkenshoSakuseiIraiYMD().wareki().toDateString());
            }
            row.setIkenshoIraiKubun(IkenshoIraiKubun.toValue(割付済み申請者.getIkenshoIraiKubun().value()).get名称());
            if (割付済み申請者.getSakuseiryoSeikyuKubun() != null && !割付済み申請者.getSakuseiryoSeikyuKubun().isEmpty()) {
                row.setSakuseiryoSeikyuKubunCode(割付済み申請者.getSakuseiryoSeikyuKubun().getColumnValue());
                row.setSakuseiryoSeikyuKubun(get作成料請求区分名称(割付済み申請者.getSakuseiryoSeikyuKubun().getColumnValue()));
            }
            row.setHokensha(nullToEmpty(hokenshaName));
            if (割付済み申請者.getJusho() != null) {
                row.setJusho(割付済み申請者.getJusho().value());
            }
            row.setShujiIryoKikan(nullToEmpty(割付済み申請者.getIryoKikanMeisho()));
            if (割付済み申請者.getShujiiName() != null) {
                row.setShujii(割付済み申請者.getShujiiName().value());
            }

            row.setZenkaiShujiIryoKikan(nullToEmpty(割付済み申請者.getTemp_iryoKikanMeisho()));
            if (割付済み申請者.getTemp_shujiiName() != null) {
                row.setZenkaiShujii(割付済み申請者.getTemp_shujiiName().value());
            }

            if (割付済み申請者.getIraishoShutsuryokuYMD() != null && 割付済み申請者.getIraishoShutsuryokuYMD().isValid()) {
                row.getIraishoShutsuryokuDay().setValue(new RDate(割付済み申請者.getIraishoShutsuryokuYMD().toString()));
            }

            if (割付済み申請者.getIkenshoShutsuryokuYMD() != null && 割付済み申請者.getIkenshoShutsuryokuYMD().isValid()) {
                row.getIkenshoShutsuryokuDay().setValue(new RDate(割付済み申請者.getIkenshoShutsuryokuYMD().toString()));
            }

            if (割付済み申請者.getSeikyushoShutsuryokuYMD() != null && 割付済み申請者.getSeikyushoShutsuryokuYMD().isValid()) {
                row.getSeikyushoShutsuryokuDay().setValue(new RDate(割付済み申請者.getSeikyushoShutsuryokuYMD().toString()));
            }

            row.getShujiiIkenshoTorokuKanryoYMD().setValue(割付済み申請者.getShujiiIkenshoTorokuKanryoYMD());
            row.setShinseishoKanriNo(nullToEmpty(割付済み申請者.getShinseishoKanriNo()));
            row.setIkenshoIraiRirekiNo(new RString(割付済み申請者.getIkenshoIraiRirekiNo()));
            row.setKoroshoIfShikibetsuCode(
                    割付済み申請者.getKoroshoIfShikibetsuCode() == null ? RString.EMPTY : 割付済み申請者.getKoroshoIfShikibetsuCode().value());
            setDgWaritsukeZumiShinseishaIchiran_Row(割付済み申請者, row);
            dataSource.add(row);
        }
        div.getDgWaritsukeZumiShinseishaIchiran().getFilterList().clear();
        div.getDgWaritsukeZumiShinseishaIchiran().setDataSource(dataSource);
        div.getTxtIkenshoSakuseiIraiDay().setValue(RDate.getNowDate());
    }

    /**
     * 未割付申請者一覧Gridに検索結果を設定します。
     *
     * @param 未割付申請者List 未割付一覧検索結果
     * @param hokenshaName 保険者名称
     */
    public void set未割付申請者一覧(List<WaritsukeBusiness> 未割付申請者List, RString hokenshaName) {
        List<dgMiwaritsukeShinseishaIchiran_Row> dataSource = new ArrayList<>();
        for (WaritsukeBusiness 未割付申請者 : 未割付申請者List) {
            dgMiwaritsukeShinseishaIchiran_Row row = new dgMiwaritsukeShinseishaIchiran_Row();
            row.setJotai(RString.EMPTY);
            row.setHihokenshaNo(nullToEmpty(未割付申請者.getHihokenshaNo()));
            row.setHihokenshaShimei(未割付申請者.getHihokenshaName() == null ? RString.EMPTY : 未割付申請者.getHihokenshaName().value());
            if (未割付申請者.getSeibetsu() != null && !RString.isNullOrEmpty(未割付申請者.getSeibetsu().value())) {
                row.setSeibetsu(Seibetsu.toValue(未割付申請者.getSeibetsu().value()).get名称());
            }
            if (未割付申請者.getNinteiShinseiYMD() != null && !未割付申請者.getNinteiShinseiYMD().isEmpty()) {
                row.getNinteiShinseiDay().setValue(new RDate(未割付申請者.getNinteiShinseiYMD().toString()));
            }
            if (未割付申請者.getNinteiShinseiKubunCode() != null && !RString.isNullOrEmpty(未割付申請者.getNinteiShinseiKubunCode().value())) {
                int ninteiShinseiKubun = Integer.parseInt(未割付申請者.getNinteiShinseiKubunCode().getColumnValue().toString());
                row.setShinseiKubunShinseiji(new RString(NinteiShinseiKubunShinsei.toValue(ninteiShinseiKubun).name()));
            }
            if (未割付申請者.getChikuCode() != null) {
                RString codeName = CodeMaster.getCodeMeisho(
                        SubGyomuCode.DBE認定支援,
                        DBECodeShubetsu.調査地区コード.getコード(),
                        new Code(未割付申請者.getChikuCode().value()),
                        FlexibleDate.getNowDate());
                if (codeName != null) {
                    row.setChiku(codeName);
                }
            }
            row.setZenkaiChosaItakusaki(nullToEmpty(未割付申請者.getTemp_jigyoshaMeisho()));
            row.setZenkaiNinteiChosainShimei(nullToEmpty(未割付申請者.getTemp_chosainShimei()));
            row.setHokensha(nullToEmpty(hokenshaName));
            row.setIkenshoIraiKubun(IkenshoIraiKubun.toValue(未割付申請者.getIkenshoIraiKubun().value()).get名称());
            if (未割付申請者.getJusho() != null) {
                row.setJusho(未割付申請者.getJusho().value());
            }
            row.setShujiiIryoKikan(nullToEmpty(未割付申請者.getIryoKikanMeisho()));
            if (未割付申請者.getShujiiName() != null) {
                row.setShujii(未割付申請者.getShujiiName().value());
            }

            row.setZenkaiShujiiIryoKikan(nullToEmpty(未割付申請者.getTemp_iryoKikanMeisho()));
            if (未割付申請者.getTemp_shujiiName() != null) {
                row.setZenkaiShujii(未割付申請者.getTemp_shujiiName().value());
            }

            row.setShinseishoKanriNo(nullToEmpty(未割付申請者.getShinseishoKanriNo()));
            row.setIkenshoIraiRirekiNo(new RString(未割付申請者.getIkenshoIraiRirekiNo()));
            row.setKoroshoIfShikibetsuCode(
                    未割付申請者.getKoroshoIfShikibetsuCode() == null ? RString.EMPTY : 未割付申請者.getKoroshoIfShikibetsuCode().value());
            setDgMiwaritsukeShinseishaIchiran_Row(row, 未割付申請者);
            dataSource.add(row);
        }
        div.getDgMiwaritsukeShinseishaIchiran().getFilterList().clear();
        div.getDgMiwaritsukeShinseishaIchiran().setDataSource(dataSource);
    }

    /**
     * 割付済み申請者一覧Gridに検索結果を設定します。
     *
     * @param miwaritsukeShinseishaRow 未割付申請者
     */
    public void set割付済み申請者一覧(dgMiwaritsukeShinseishaIchiran_Row miwaritsukeShinseishaRow) {
        dgWaritsukeZumiShinseishaIchiran_Row row = new dgWaritsukeZumiShinseishaIchiran_Row();
        RString jotai = miwaritsukeShinseishaRow.getJotai();
        if (割付解除.equals(jotai)) {
            row.setJotai(RString.EMPTY);
        } else {
            row.setJotai(未割付);
        }
        row.setHokenshaNo(miwaritsukeShinseishaRow.getHokenshaNo());
        row.setHihokenshaNo(miwaritsukeShinseishaRow.getHihokenshaNo());
        row.setHihokenshaShimei(miwaritsukeShinseishaRow.getHihokenshaShimei());
        row.setSeibetsu(miwaritsukeShinseishaRow.getSeibetsu());
        row.setNinteiShinseiDay(miwaritsukeShinseishaRow.getNinteiShinseiDay());
        row.setShinseiKubunShinseiji(miwaritsukeShinseishaRow.getShinseiKubunShinseiji());
        row.setChiku(miwaritsukeShinseishaRow.getChiku());
        row.setZenkaiChosaItakusaki(miwaritsukeShinseishaRow.getZenkaiChosaItakusaki());
        row.setZenkaiChosain(miwaritsukeShinseishaRow.getZenkaiNinteiChosainShimei());
        row.setIkenshoSakuseiIraiDay(miwaritsukeShinseishaRow.getIkenshoSakuseiIraiDay());
        row.setIkenshoIraiKubun(miwaritsukeShinseishaRow.getIkenshoIraiKubun());
        RString 作成料請求区分コード = SakuseiryoSeikyuKubunFinder.createInstance()
                .search作成料請求区分(new ShinseishoKanriNo(miwaritsukeShinseishaRow.getShinseishoKanriNo()));
        row.setSakuseiryoSeikyuKubunCode(作成料請求区分コード);
        row.setSakuseiryoSeikyuKubun(get作成料請求区分名称(作成料請求区分コード));
        row.setHokensha(miwaritsukeShinseishaRow.getHokensha());
        row.setJusho(miwaritsukeShinseishaRow.getJusho());
        row.setShujiIryoKikan(miwaritsukeShinseishaRow.getShujiiIryoKikan());
        row.setShujii(miwaritsukeShinseishaRow.getShujii());
        row.setZenkaiShujiIryoKikan(miwaritsukeShinseishaRow.getZenkaiShujiiIryoKikan());
        row.setZenkaiShujii(miwaritsukeShinseishaRow.getZenkaiShujii());
        row.setIraishoShutsuryokuDay(miwaritsukeShinseishaRow.getIraishoShutsuryokuDay());
        row.setIkenshoShutsuryokuDay(miwaritsukeShinseishaRow.getIkenshoShutsuryokuDay());
        row.setSeikyushoShutsuryokuDay(miwaritsukeShinseishaRow.getSeikyushoShutsuryokuDay());
        row.setShinseishoKanriNo(miwaritsukeShinseishaRow.getShinseishoKanriNo());
        row.setIkenshoIraiRirekiNo(miwaritsukeShinseishaRow.getIkenshoIraiRirekiNo());
        row.setKoroshoIfShikibetsuCode(miwaritsukeShinseishaRow.getKoroshoIfShikibetsuCode());
        row.setHihokenshaKana(miwaritsukeShinseishaRow.getHihokenshaKana());
        row.setSeinengappiYMD(miwaritsukeShinseishaRow.getSeinengappiYMD());
        row.setYubinNo(miwaritsukeShinseishaRow.getYubinNo());
        row.setTelNo(miwaritsukeShinseishaRow.getTelNo());
        row.setNinteiShinseiYMDKoShin(miwaritsukeShinseishaRow.getNinteiShinseiYMDKoShin());
        row.setZenkaiNinteiYMD(miwaritsukeShinseishaRow.getZenkaiNinteiYMD());
        row.setZenYokaigoKubunCode(miwaritsukeShinseishaRow.getZenYokaigoKubunCode());
        row.setAge(miwaritsukeShinseishaRow.getAge());
        row.setShujiiIkenshoTorokuKanryoYMD(miwaritsukeShinseishaRow.getShujiiIkenshoTorokuKanryoYMD());
        div.getDgWaritsukeZumiShinseishaIchiran().getDataSource().add(row);
    }

    /**
     * 未割付申請者一覧Gridに割付済み申請者を設定します。
     *
     * @param waritsukeZumiShinseishaRow 割付済み申請者
     */
    public void set未割付申請者一覧(dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaRow) {
        dgMiwaritsukeShinseishaIchiran_Row row = new dgMiwaritsukeShinseishaIchiran_Row();
        RString jotai = waritsukeZumiShinseishaRow.getJotai();
        if (未割付.equals(jotai)) {
            row.setJotai(RString.EMPTY);
        } else {
            row.setJotai(割付解除);
        }
        row.setHokenshaNo(waritsukeZumiShinseishaRow.getHokenshaNo());
        row.setHihokenshaNo(waritsukeZumiShinseishaRow.getHihokenshaNo());
        row.setHihokenshaShimei(waritsukeZumiShinseishaRow.getHihokenshaShimei());
        row.setSeibetsu(waritsukeZumiShinseishaRow.getSeibetsu());
        row.setNinteiShinseiDay(waritsukeZumiShinseishaRow.getNinteiShinseiDay());
        row.setShinseiKubunShinseiji(waritsukeZumiShinseishaRow.getShinseiKubunShinseiji());
        row.setChiku(waritsukeZumiShinseishaRow.getChiku());
        row.setZenkaiChosaItakusaki(waritsukeZumiShinseishaRow.getZenkaiChosaItakusaki());
        row.setZenkaiNinteiChosainShimei(waritsukeZumiShinseishaRow.getZenkaiChosain());
        row.setHokensha(waritsukeZumiShinseishaRow.getHokensha());
        row.setIkenshoIraiKubun(waritsukeZumiShinseishaRow.getIkenshoIraiKubun());
        row.setJusho(waritsukeZumiShinseishaRow.getJusho());
        row.setShujiiIryoKikan(waritsukeZumiShinseishaRow.getShujiIryoKikan());
        row.setShujii(waritsukeZumiShinseishaRow.getShujii());
        row.setZenkaiShujiiIryoKikan(waritsukeZumiShinseishaRow.getZenkaiShujiIryoKikan());
        row.setZenkaiShujii(waritsukeZumiShinseishaRow.getZenkaiShujii());
        row.setIkenshoSakuseiIraiDay(waritsukeZumiShinseishaRow.getIkenshoSakuseiIraiDay());
        row.setIraishoShutsuryokuDay(waritsukeZumiShinseishaRow.getIraishoShutsuryokuDay());
        row.setIkenshoShutsuryokuDay(waritsukeZumiShinseishaRow.getIkenshoShutsuryokuDay());
        row.setSeikyushoShutsuryokuDay(waritsukeZumiShinseishaRow.getSeikyushoShutsuryokuDay());
        row.setShinseishoKanriNo(waritsukeZumiShinseishaRow.getShinseishoKanriNo());
        row.setIkenshoIraiRirekiNo(waritsukeZumiShinseishaRow.getIkenshoIraiRirekiNo());
        row.setKoroshoIfShikibetsuCode(waritsukeZumiShinseishaRow.getKoroshoIfShikibetsuCode());
        row.setHihokenshaKana(waritsukeZumiShinseishaRow.getHihokenshaKana());
        row.setSeinengappiYMD(waritsukeZumiShinseishaRow.getSeinengappiYMD());
        row.setYubinNo(waritsukeZumiShinseishaRow.getYubinNo());
        row.setTelNo(waritsukeZumiShinseishaRow.getTelNo());
        row.setNinteiShinseiYMDKoShin(waritsukeZumiShinseishaRow.getNinteiShinseiYMDKoShin());
        row.setZenkaiNinteiYMD(waritsukeZumiShinseishaRow.getZenkaiNinteiYMD());
        row.setZenYokaigoKubunCode(waritsukeZumiShinseishaRow.getZenYokaigoKubunCode());
        row.setAge(waritsukeZumiShinseishaRow.getAge());
        row.setShujiiIkenshoTorokuKanryoYMD(waritsukeZumiShinseishaRow.getShujiiIkenshoTorokuKanryoYMD());
        div.getDgMiwaritsukeShinseishaIchiran().getDataSource().add(row);
    }

    /**
     * 変更かあるか判定します。
     *
     * @return 判断結果（編集内容があるの場合:true、編集内容がなしの場合：false）
     */
    public boolean exist変更() {
        List<dgMiwaritsukeShinseishaIchiran_Row> dgMiwaritsukeShinseishaIchiran = div.getDgMiwaritsukeShinseishaIchiran().getDataSource();
        for (dgMiwaritsukeShinseishaIchiran_Row miwaritsukeShinseishaRow : dgMiwaritsukeShinseishaIchiran) {
            if (割付解除.equals(miwaritsukeShinseishaRow.getJotai())) {
                return true;
            }
        }
        List<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseisha = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        for (dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaRow : dgWaritsukeZumiShinseisha) {
            if (未割付.equals(waritsukeZumiShinseishaRow.getJotai())) {
                return true;
            }
        }
        return false;
    }

    private RString nullToEmpty(RString obj) {
        return (obj != null) ? obj : RString.EMPTY;
    }

    private void setNinteiShinseiJoho(WaritsukeBusiness 割付済み申請者, dgWaritsukeZumiShinseishaIchiran_Row row) throws IllegalArgumentException {
        if (割付済み申請者.getNinteiShinseiYMD() != null && 割付済み申請者.getNinteiShinseiYMD().isValid()) {
            row.getNinteiShinseiDay().setValue(new RDate(割付済み申請者.getNinteiShinseiYMD().toString()));
        }
        if (割付済み申請者.getNinteiShinseiKubunCode() != null && !RString.isNullOrEmpty(割付済み申請者.getNinteiShinseiKubunCode().value())) {
            int ninteiShinseiKubun = Integer.parseInt(割付済み申請者.getNinteiShinseiKubunCode().getColumnValue().toString());
            row.setShinseiKubunShinseiji(new RString(NinteiShinseiKubunShinsei.toValue(ninteiShinseiKubun).name()));
        }
    }

    private void setDgWaritsukeZumiShinseishaIchiran_Row(WaritsukeBusiness 割付済み申請者, dgWaritsukeZumiShinseishaIchiran_Row row) {
        row.setHihokenshaKana(割付済み申請者.getHihokenshaKana() == null ? RString.EMPTY : 割付済み申請者.getHihokenshaKana().value());
        if (割付済み申請者.getSeinengappiYMD() != null) {
            row.setSeinengappiYMD(new RString(割付済み申請者.getSeinengappiYMD().toString()));
        }
        row.setYubinNo(割付済み申請者.getYubinNo() == null ? RString.EMPTY : 割付済み申請者.getYubinNo().value());
        row.setTelNo(割付済み申請者.getTelNo() == null ? RString.EMPTY : 割付済み申請者.getTelNo().value());
        if (割付済み申請者.getNinteiShinseiYMDKoShin() != null) {
            row.setNinteiShinseiYMDKoShin(new RString(割付済み申請者.getNinteiShinseiYMDKoShin().toString()));
        }
        if (割付済み申請者.getZenkaiNinteiYMD() != null) {
            row.setZenkaiNinteiYMD(new RString(割付済み申請者.getZenkaiNinteiYMD().toString()));
        }
        row.setZenYokaigoKubunCode(割付済み申請者.getZenYokaigoKubunCode() == null ? RString.EMPTY : 割付済み申請者.getZenYokaigoKubunCode().value());
        row.setAge(new RString(割付済み申請者.getAge()));
        row.setHokenshaNo(nullToEmpty(割付済み申請者.getHokenshaNo()));
        row.setShichosonCode(nullToEmpty(割付済み申請者.getShichosonCode()));
    }

    private void setDgMiwaritsukeShinseishaIchiran_Row(dgMiwaritsukeShinseishaIchiran_Row row, WaritsukeBusiness 未割付申請者) {
        row.setHihokenshaKana(未割付申請者.getHihokenshaKana() == null ? RString.EMPTY : 未割付申請者.getHihokenshaKana().value());
        if (未割付申請者.getSeinengappiYMD() != null) {
            row.setSeinengappiYMD(new RString(未割付申請者.getSeinengappiYMD().toString()));
        }
        row.setYubinNo(未割付申請者.getYubinNo() == null ? RString.EMPTY : 未割付申請者.getYubinNo().value());
        row.setTelNo(未割付申請者.getTelNo() == null ? RString.EMPTY : 未割付申請者.getTelNo().value());
        if (未割付申請者.getNinteiShinseiYMDKoShin() != null && !未割付申請者.getNinteiShinseiYMDKoShin().isEmpty()) {
            row.setNinteiShinseiYMDKoShin(new RString(未割付申請者.getNinteiShinseiYMDKoShin().toString()));
        }
        if (未割付申請者.getZenkaiNinteiYMD() != null && !未割付申請者.getZenkaiNinteiYMD().isEmpty()) {
            row.setZenkaiNinteiYMD(new RString(未割付申請者.getZenkaiNinteiYMD().toString()));
        }
        row.setZenYokaigoKubunCode(未割付申請者.getZenYokaigoKubunCode() == null ? RString.EMPTY : 未割付申請者.getZenYokaigoKubunCode().value());
        row.setAge(new RString(未割付申請者.getAge()));
        row.setHokenshaNo(未割付申請者.getHokenshaNo());
    }

    /**
     * 作成料請求区分名称を取得します。
     *
     * @param 作成料請求区分コード RString
     * @return 作成料請求区分名称 RString
     */
    private RString get作成料請求区分名称(RString 作成料請求区分コード) {
        RString 作成料請求区分名称 = RString.EMPTY;
        if (RString.isNullOrEmpty(作成料請求区分コード)) {
            return 作成料請求区分名称;
        }
        for (SakuseiryoSeikyuKubun sakuseiryoSeikyuKubun : SakuseiryoSeikyuKubun.values()) {
            if (sakuseiryoSeikyuKubun.getコード().equals(作成料請求区分コード)) {
                作成料請求区分名称 = sakuseiryoSeikyuKubun.get名称();
            }
        }
        return 作成料請求区分名称;
    }
}
