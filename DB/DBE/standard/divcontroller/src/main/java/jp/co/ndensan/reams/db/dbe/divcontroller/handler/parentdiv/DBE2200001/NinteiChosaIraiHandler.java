package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2200001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinnteiChousairaiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.NinteiChosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgChosaItakusakiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgMiwaritsukeShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgWaritsukeZumiShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgchosainIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 認定調査員マスタ画面のハンドラークラスです。
 */
public class NinteiChosaIraiHandler {

    private static final CodeShubetsu CHIKU_CODE_SHUBETSU = new CodeShubetsu("5001");
    private final NinteiChosaIraiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査依頼Div
     */
    public NinteiChosaIraiHandler(NinteiChosaIraiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void load() {
        div.getCcdHokenshaList().loadHokenshaList();
        div.getTxtChosaItakusakiCode().clearValue();
        div.getTxtChosaItakusakiMeisho().clearValue();
        div.getTxtChosaItakusakiChiku().clearValue();
        div.getTxtChosainCode().clearValue();
        div.getTxtChosainShimei().clearValue();
        div.getTxtChosainChiku().clearValue();
        setDisabledToChosaItakusakiAndChosainKihonJoho(true);
        if (is単一保険者()) {
            div.getCcdHokenshaList().setDisabled(false);
        } else {
            div.getCcdHokenshaList().setDisabled(true);
        }
    }

    /**
     * 単一保険者と広域保険者の判断処理です。
     *
     * @return 判断結果(true:単一保険者,false:広域保険者)
     */
    public boolean is単一保険者() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().value();
        if (DonyukeitaiCode.事務単一.getCode().equals(導入形態コード)
                || DonyukeitaiCode.認定単一.getCode().equals(導入形態コード)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 認定調査委託先一覧に検索結果を設定します。
     *
     * @param 認定調査委託先List 認定調査委託先List
     */
    public void set認定調査委託先一覧(List<NinnteiChousairaiBusiness> 認定調査委託先List) {
        List<dgChosaItakusakiIchiran_Row> dataSource = new ArrayList<>();
        RString 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード().value();
        RString 市町村名称 = div.getCcdHokenshaList().getSelectedItem().get市町村名称();
        for (NinnteiChousairaiBusiness business : 認定調査委託先List) {
            dgChosaItakusakiIchiran_Row row = new dgChosaItakusakiIchiran_Row();
            TextBoxCode chosaItakusakiCode = new TextBoxCode();
            chosaItakusakiCode.setValue(nullToEmpty(business.getNinteichosaItakusakiCode()));
            row.setChosaItakusakiCode(chosaItakusakiCode);
            row.setChosaItakusakiMeisho(nullToEmpty(business.getJigyoshaMeisho()));
            UzT0007CodeEntity codeEntity = null;
            if (business.getWaritsukeChiku() != null) {
                codeEntity = CodeMaster.getCode(
                        SubGyomuCode.DBE認定支援,
                        CHIKU_CODE_SHUBETSU,
                        new Code(business.getWaritsukeChiku().value()));
            }

            if (codeEntity != null) {
                row.setChosaChiku(nullToEmpty(codeEntity.getコード名称()));
            }
            TextBoxNum waritsukeTeiin = new TextBoxNum();
            waritsukeTeiin.setValue(new Decimal(business.getWaritsukeTeiin()));
            row.setWaritsukeTeiin(waritsukeTeiin);
            TextBoxNum waritsukeZumi = new TextBoxNum();
            waritsukeZumi.setValue(new Decimal(business.getWaritsukesumiKensu()));
            row.setWaritsukeZumi(waritsukeZumi);
            row.setChosaItakusakiJusho(nullToEmpty(business.getJusho()));
            row.setChosaItakusakiTelNo(business.getTelNo() == null ? RString.EMPTY : business.getTelNo().value());
            row.setChosaItakusakiKubun(nullToEmpty(business.getKikanKubun()));
            // TODO
            row.setHokenshaCode(nullToEmpty(市町村コード));
            row.setHokenshaName(nullToEmpty(市町村名称));
            dataSource.add(row);
        }
        div.getDgChosaItakusakiIchiran().setDataSource(dataSource);
    }

    /**
     * 調査員情報一覧に検索結果を設定します。
     *
     * @param 調査員情報一覧List 調査員情報一覧List
     * @param selectRow dgChosaItakusakiIchiran_Row
     */
    public void set調査員情報一覧(List<NinnteiChousairaiBusiness> 調査員情報一覧List, dgChosaItakusakiIchiran_Row selectRow) {
        List<dgchosainIchiran_Row> dataSource = new ArrayList<>();
        for (NinnteiChousairaiBusiness business : 調査員情報一覧List) {
            dgchosainIchiran_Row row = new dgchosainIchiran_Row();
            TextBoxCode chosainCode = new TextBoxCode();
            chosainCode.setValue(nullToEmpty(business.getChikuCode()));
            row.setChosainCode(chosainCode);
            row.setChosainShimei(nullToEmpty(business.getChosainShimei()));
            row.setChosainKanaShimei(nullToEmpty(business.getChosainKanaShimei()));
            if (!RString.isNullOrEmpty(business.getSeibetsu())) {
                row.setChosainSeibetsu(Seibetsu.toValue(business.getSeibetsu()).get名称());
            }
            row.setChosainTelNo(business.getTelNo() == null ? RString.EMPTY : business.getTelNo().value());
            row.setChosaChiku(nullToEmpty(business.getChikuCode()));
            TextBoxNum waritsukeZumi = new TextBoxNum();
            waritsukeZumi.setValue(new Decimal(business.getWaritsukesumiKensu()));
            row.setWaritsukeZumi(waritsukeZumi);
            row.setChosainShikaku(nullToEmpty(business.getChosainShikaku()));
            row.setHokenshaCode(nullToEmpty(selectRow.getHokenshaCode()));
            row.setHokenshaName(nullToEmpty(selectRow.getHokenshaName()));
            dataSource.add(row);
        }
        div.getDgchosainIchiran().setDataSource(dataSource);
    }

    /**
     * 未割付申請者一覧Gridに検索結果を設定します。
     *
     * @param 未割付一覧 未割付一覧検索結果
     * @param hokenshaName 保険者名称
     */
    public void set未割付申請者一覧(List<WaritsukeBusiness> 未割付一覧, RString hokenshaName) {
        List<dgMiwaritsukeShinseishaIchiran_Row> dataSource = new ArrayList<>();
        int i = 1;
        for (WaritsukeBusiness business : 未割付一覧) {
            dgMiwaritsukeShinseishaIchiran_Row row = new dgMiwaritsukeShinseishaIchiran_Row();
            row.setNo(new RString(String.valueOf(i++)));
            row.setJotai(RString.EMPTY);
            row.setHihokenshaNo(nullToEmpty(business.getHihokenshaNo()));
            row.setHihokenshaShimei(business.getHihokenshaName() == null ? RString.EMPTY : business.getHihokenshaName().value());
            if (business.getSeibetsu() != null && !RString.isNullOrEmpty(business.getSeibetsu().value())) {
                row.setSeibetsu(Seibetsu.toValue(business.getSeibetsu().value()).get名称());
            }
            if (business.getNinteiShinseiYMD() != null) {
                TextBoxDate ninteiShinseiDay = new TextBoxDate();
                ninteiShinseiDay.setValue(new RDate(business.getNinteiShinseiYMD().toString()));
                row.setNinteiShinseiDay(ninteiShinseiDay);
            }
            if (business.getNinteiShinseiKubunCode() != null) {
                int ninteiShinseiKubun = Integer.parseInt(business.getNinteiShinseiKubunCode().getColumnValue().toString());
                row.setShinseiKubunShinseiji(new RString(NinteiShinseiKubunShinsei.toValue(ninteiShinseiKubun).name()));
            }
            if (business.getChikuCode() != null) {
                row.setChiku(business.getChikuCode().value());
            }
            if (business.getTemp_shujiiName() != null) {
                row.setZenkaiChosaItakusaki(business.getTemp_shujiiName().value());
            }
            row.setZenkaiNinteiChosainShimei(nullToEmpty(business.getTemp_chosainShimei()));
            row.setHokensha(hokenshaName);
            if (business.getChosaKubun() != null) {
                row.setChosaKubun(ChosaKubun.toValue(business.getChosaKubun().value()).getコード());
            }
            if (business.getJusho() != null) {
                row.setJusho(business.getJusho().value());
            }
            row.setShujiiIryoKikan(nullToEmpty(business.getIryoKikanMeisho()));
            if (business.getShujiiName() != null) {
                row.setShujii(business.getShujiiName().value());
            }

            row.setZenkaiShujiiIryoKikan(nullToEmpty(business.getTemp_jigyoshaMeisho()));
            row.setZenkaiShujii(nullToEmpty(business.getTemp_iryoKikanMeisho()));
            dataSource.add(row);
        }
        div.getDgMiwaritsukeShinseishaIchiran().setDataSource(dataSource);
    }

    /**
     * 割付済み申請者一覧Gridに検索結果を設定します。
     *
     * @param 割付済み申請者一覧 割付済み申請者一覧検索結果
     * @param hokenshaName 保険者名称
     */
    public void set割付済み申請者一覧(List<WaritsukeBusiness> 割付済み申請者一覧, RString hokenshaName) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> dataSource = new ArrayList<>();
        int i = 1;
        for (WaritsukeBusiness business : 割付済み申請者一覧) {
            dgWaritsukeZumiShinseishaIchiran_Row row = new dgWaritsukeZumiShinseishaIchiran_Row();
            TextBoxNum num = new TextBoxNum();
            num.setValue(new Decimal(i++));
            row.setNo(num);
            row.setJotai(RString.EMPTY);
            row.setHihokenshaNo(nullToEmpty(business.getHihokenshaNo()));
            row.setHihokenshaShimei(business.getHihokenshaName() == null ? RString.EMPTY : business.getHihokenshaName().value());
            if (business.getSeibetsu() != null && !RString.isNullOrEmpty(business.getSeibetsu().value())) {
                row.setSeibetsu(Seibetsu.toValue(business.getSeibetsu().value()).get名称());
            }
            if (business.getNinteiShinseiYMD() != null) {
                TextBoxDate ninteiShinseiDay = new TextBoxDate();
                ninteiShinseiDay.setValue(new RDate(business.getNinteiShinseiYMD().toString()));
                row.setNinteiShinseiDay(ninteiShinseiDay);
            }
            if (business.getNinteiShinseiKubunCode() != null) {
                int ninteiShinseiKubun = Integer.parseInt(business.getNinteiShinseiKubunCode().getColumnValue().toString());
                row.setShinseiKubunShinseiji(new RString(NinteiShinseiKubunShinsei.toValue(ninteiShinseiKubun).name()));
            }
            if (business.getChikuCode() != null) {
                row.setChiku(business.getChikuCode().value());
            }
            if (business.getTemp_shujiiName() != null) {
                row.setZenkaiChosaItakusaki(business.getTemp_shujiiName().value());
            }
            row.setZenkaiChosain(nullToEmpty(business.getTemp_chosainShimei()));

            if (business.getNinteichosaIraiYMD() != null) {
                row.setChosaIraiDay(business.getNinteichosaIraiYMD().wareki().toDateString());
            }
            if (business.getChosaKubun() != null) {
                row.setChosaKubun(ChosaKubun.toValue(business.getChosaKubun().value()).getコード());
            }

            row.setHokensha(hokenshaName);
            if (business.getJusho() != null) {
                row.setJusho(business.getJusho().value());
            }
            row.setShujiIryoKikan(nullToEmpty(business.getIryoKikanMeisho()));
            if (business.getShujiiName() != null) {
                row.setShujii(business.getShujiiName().value());
            }

            row.setZenkaiShujiIryoKikan(nullToEmpty(business.getTemp_jigyoshaMeisho()));
            row.setZenkaiShujii(nullToEmpty(business.getTemp_iryoKikanMeisho()));
            TextBoxDate iraishoShutsuryokuDay = new TextBoxDate();
            iraishoShutsuryokuDay.setValue(new RDate(business.getIraishoShutsuryokuYMD().toString()));
            row.setIraishoShutsuryokuDay(iraishoShutsuryokuDay);
            TextBoxDate chosahyoNadoShutsuryookuDay = new TextBoxDate();
            chosahyoNadoShutsuryookuDay.setValue(new RDate(business.getChosahyoTouShutsuryokuYMD().toString()));
            row.setChosahyoNadoShutsuryookuDay(chosahyoNadoShutsuryookuDay);
            dataSource.add(row);
        }
        div.getDgWaritsukeZumiShinseishaIchiran().setDataSource(dataSource);
    }

    /**
     * 委託先基本情報に検索結果を設定します。
     *
     * @param row 認定調査委託先
     */
    public void set委託先基本情報(dgChosaItakusakiIchiran_Row row) {
        div.getTxtChosaItakusakiCode().setValue(row.getChosaItakusakiCode().getValue());
        div.getTxtChosaItakusakiMeisho().setValue(row.getChosaItakusakiMeisho());
        div.getTxtChosaItakusakiChiku().setValue(row.getChosaChiku());
        div.getTxtChosainCode().clearValue();
        div.getTxtChosainShimei().clearValue();
        div.getTxtChosainChiku().clearValue();
    }

    /**
     * 委託先基本情報に検索結果を設定します。
     *
     * @param row 認定調査委託先
     */
    public void set委託先基本情報(dgchosainIchiran_Row row) {
        div.getTxtChosainCode().setValue(row.getChosainCode().getValue());
        div.getTxtChosainShimei().setValue(row.getChosainShimei());
        div.getTxtChosainChiku().setValue(row.getChosaChiku());
    }

    /**
     * 委託先基本情報に非活用/活用を設定します。
     *
     * @param disabled (true:非活用,false:活用)
     */
    public void setDisabledToChosaItakusakiAndChosainKihonJoho(boolean disabled) {
        div.getTxtChosaItakusakiCode().setDisabled(disabled);
        div.getTxtChosaItakusakiMeisho().setDisabled(disabled);
        div.getTxtChosaItakusakiChiku().setDisabled(disabled);
        div.getTxtChosainCode().setDisabled(disabled);
        div.getTxtChosainShimei().setDisabled(disabled);
        div.getTxtChosainChiku().setDisabled(disabled);
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        } else {
            return obj;
        }
    }
}
