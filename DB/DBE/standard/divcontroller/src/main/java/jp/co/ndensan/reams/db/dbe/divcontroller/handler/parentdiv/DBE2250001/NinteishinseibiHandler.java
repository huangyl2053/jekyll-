/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2250001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.niteicyosaichiran.NiTeiCyoSaiChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.ChosaKekkaNyuryokuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.NinteishinseibiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.dgNinteiChosaData_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokkiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlagBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 認定調査データ取込（モバイル）のHandlerラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
public class NinteishinseibiHandler {

    private final NinteishinseibiDiv div;
    private static final RString 取込 = new RString("import");
    private static final RString 保存 = new RString("update");
    private static final RString 完了 = new RString("complete");

    /**
     * コンストラクタです。
     *
     * @param div NinteishinseibiDiv
     */
    public NinteishinseibiHandler(NinteishinseibiDiv div) {
        this.div = div;
    }

    /**
     * 認定調査データ取込の設定します。
     *
     */
    public void initializtion() {
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 最大上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTxtMaxKensu().setValue(new Decimal(最大表示件数.toString()));
        div.getTxtMaxKensu().setMaxValue(new Decimal(最大上限.toString()));
        初期状態();
    }

    /**
     * 条件をクリアする。
     *
     */
    public void clear() {
        div.getTxtNinteishinseibi().clearFromValue();
        div.getTxtNinteishinseibi().clearToValue();
        div.getTxtiraibi().clearFromValue();
        div.getTxtiraibi().clearToValue();
        div.getTxtMaxKensu().clearValue();
    }

    private void 初期状態() {
        div.getNinteiIchiran().setDisplayNone(true);
        div.getCcdKanryoMessage().setDisplayNone(true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(取込, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(完了, true);
    }

    /**
     * 保存状態の遷移。
     *
     */
    public void 保存状態() {

        div.getCcdKanryoMessage().setDisplayNone(false);
        div.getTxtNinteishinseibi().setDisplayNone(true);
        div.getTxtiraibi().setDisplayNone(true);
        div.getBtnKensakuClear().setDisplayNone(true);
        div.getNinteiIchiran().setDisplayNone(true);
        div.getBtnKensaku().setDisplayNone(true);
        div.getTxtMaxKensu().setDisplayNone(true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(取込, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(完了, false);
    }

    /**
     * 認定調査データ取込に検索処理を実行します。
     *
     * @param 認定調査一覧 List<NiTeiCyoSaiChiRanBusiness>
     * @param personalData PersonalData
     */
    public void 検索処理(List<NiTeiCyoSaiChiRanBusiness> 認定調査一覧, PersonalData personalData) {
        データ一覧状態(認定調査一覧);
        一覧の編集(認定調査一覧, personalData);
    }

    private void データ一覧状態(List<NiTeiCyoSaiChiRanBusiness> 認定調査一覧) {
        div.getNinteiIchiran().setDisplayNone(false);
        if (!認定調査一覧.isEmpty()) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(取込, false);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存, false);
        }
    }

    private void 一覧の編集(List<NiTeiCyoSaiChiRanBusiness> 認定調査一覧, PersonalData personalData) {

        div.getTxtNinzu().setValue(new RString(String.valueOf(認定調査一覧.size())));
        List<dgNinteiChosaData_Row> rowList = new ArrayList<>();
        for (NiTeiCyoSaiChiRanBusiness business : 認定調査一覧) {

            dgNinteiChosaData_Row row = new dgNinteiChosaData_Row();

            一覧の編集_1(business, row);
            一覧の編集_2(business, row);
            personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    business.get申請書管理番号().value()));
            rowList.add(row);
        }
        div.getDgNinteiChosaData().setDataSource(rowList);
    }

    /**
     * 認定調査データ取込に一覧編集を実行します。
     *
     * @param 認定調査一覧 List<NiTeiCyoSaiChiRanBusiness>
     */
    public void 一覧の再編集(List<NiTeiCyoSaiChiRanBusiness> 認定調査一覧) {

        div.getTxtNinzu().setValue(new RString(String.valueOf(認定調査一覧.size())));
        List<dgNinteiChosaData_Row> rowList = new ArrayList<>();
        for (NiTeiCyoSaiChiRanBusiness business : 認定調査一覧) {

            dgNinteiChosaData_Row row = new dgNinteiChosaData_Row();

            一覧の編集_1(business, row);
            一覧の編集_2(business, row);
            rowList.add(row);
        }
        div.getDgNinteiChosaData().setDataSource(rowList);
    }

    private void 一覧の編集_1(NiTeiCyoSaiChiRanBusiness business, dgNinteiChosaData_Row row) {

        row.setShichosonMeisho(business.get保険者());
        if (business.get認定申請年月日() != null) {

            row.setNinteiShinseiYMD(business.get認定申請年月日().wareki().toDateString());
        }
        row.setHihokenshaNo(business.get被保険者番号());
        if (business.get被保険者氏名() != null) {
            row.setHihokenshaName(business.get被保険者氏名().value());
        }
        if (business.get認定申請区分_申請時コード() != null) {

            row.setNinteiShinseiShinseijiKubunCode(NinteiShinseiShinseijiKubunCode.
                    toValue(business.get認定申請区分_申請時コード().value()).get名称());
        }
        if (business.get認定調査依頼完了年月日() != null) {
            row.setNinteichosaIraiKanryoYMD(business.get認定調査依頼完了年月日().wareki().toDateString());
        }
        if (business.get認定調査委託先コード() != null) {
            row.setNinteiChosaItakusakiCode(business.get認定調査委託先コード().value());
        }
        if (business.get認定調査員コード() != null) {
            row.setNinteiChosainCode(business.get認定調査員コード().value());
        }
        if (business.get認定調査完了年月日() != null) {
            row.setNinteichosaKanryoYMD(business.get認定調査完了年月日().wareki().toDateString());
        }
        if (business.get認定調査実施年月日() != null) {
            row.setNinteichosaJisshiYMD(business.get認定調査実施年月日().wareki().toDateString());
        }
        row.setShinseishoKanriNo(business.get申請書管理番号().value());
        row.setNinteichosaIraiRirekiNo(new RString(String.valueOf(business.get認定調査依頼履歴番号())));
        row.setRemban(new RString(String.valueOf(business.get調査項目連番())));
        row.setKoroshoIfShikibetsuCode(business.get厚労省IF識別コード().value());
        row.setShisetsuRiyoFlag(new RString(String.valueOf(business.is施設利用フラグ())));
        row.setServiceJokyoKinyu(business.getサービスの状況記入());
        row.setServiceJokyo(new RString(String.valueOf(business.getサービスの状況())));
        row.setResearchItem(business.get調査項目());
    }

    private void 一覧の編集_2(NiTeiCyoSaiChiRanBusiness business, dgNinteiChosaData_Row row) {

        if (business.get認知症高齢者の日常生活自立度コード() != null) {
            row.setNinchishoNichijoSeikatsuJiritsudoCode(NinchishoNichijoSeikatsuJiritsudoCode.
                    toValue(business.get認知症高齢者の日常生活自立度コード().value()).get名称());
        }
        if (business.get障害高齢者の日常生活自立度コード() != null) {
            row.setShogaiNichijoSeikatsuJiritsudoCode(NinchishoNichijoSeikatsuJiritsudoCode.
                    toValue(business.get障害高齢者の日常生活自立度コード().value()).get名称());
        }
        row.setNinteichosaTokkijikoNo(business.get認定調査特記事項番号());
        row.setNinteichosaTokkijikoRemban(new RString(String.valueOf(business.get認定調査特記事項連番())));
        if (!RString.isNullOrEmpty(business.get概況特記テキストイメージ区分())) {

            row.setGaikyoTokkiTextImageKubun(TokkijikoTextImageKubun.toValue(business.get概況特記テキストイメージ区分()).get名称());
        }
        if (business.get原本マスク区分() != null) {
            row.setGenponMaskKubun(GenponMaskKubun.toValue(business.get原本マスク区分().value()).get名称());
        }
        row.setTokkiJiko(business.get特記事項());
        row.setJutakuKaishu(business.get住宅改修_改修箇所());
        row.setTokubetsuKyufuService(business.get市町村特別給付サービス種類名());
        row.setZaitakuService(business.get介護保険給付以外の在宅サービス種類名());
        row.setShuso(business.get概況特記事項_主訴());
        row.setKazokuJokyo(business.get概況特記事項_家族状況());
        row.setKyojuKankyo(business.get概況特記事項_居住環境());
        row.setKikaiKiki(business.get器械());
        if (business.get認定調査依頼区分コード() != null && !RString.isNullOrEmpty(business.get認定調査依頼区分コード().value())) {
            row.setNinteichousaIraiKubunCode(NinteiChousaIraiKubunCode.toValue(business.get認定調査依頼区分コード().value()).get名称());
        }
        row.setNinteichosaIraiKaisu(new RString(String.valueOf(business.get認定調査回数())));
        if (business.get認定調査受領年月日() != null) {
            row.setNinteichosaJuryoYMD(business.get認定調査受領年月日().wareki().toDateString());
        }
        if (business.get認定調査区分コード() != null) {
            row.setNinteiChosaKubunCode(business.get認定調査区分コード().value());
        }
        if (business.get認定調査実施場所コード() != null) {
            row.setChosaJisshiBashoCode(business.get認定調査実施場所コード().value());
        }
        row.setChosaJisshiBashoMeisho(business.get認定調査実施場所名称());
        if (business.getサービス区分コード() != null && !RString.isNullOrEmpty(business.getサービス区分コード().value())) {
            row.setServiceKubunCode(ServiceKubunCode.toValue(business.getサービス区分コード().value()).get名称());
        }
        row.setRiyoShisetsuShimei(business.get利用施設名());
        row.setRiyoShisetsuJusho(business.get利用施設住所());
        row.setRiyoShisetsuTelNo(business.get利用施設電話番号());
        if (business.get利用施設郵便番号() != null) {
            row.setRiyoShisetsuYubinNo(business.get利用施設郵便番号().getEditedYubinNo());
        }
        row.setTokki(business.get特記());
        if (business.get認定調査特記事項受付年月日() != null) {
            row.setTokkijikoUketsukeYMD(business.get認定調査特記事項受付年月日().wareki().toDateString());
        }
        if (business.get認定調査特記事項受領年月日() != null) {
            row.setTokkijikoJuryoYMD(business.get認定調査特記事項受領年月日().wareki().toDateString());
        }
        row.setServiceJokyoFlag(new RString(String.valueOf(business.isサービスの状況フラグ())));
        row.setServiceJokyoRemban(new RString(String.valueOf(business.getサービスの状況連番())));
        row.setServiceJokyoFlagRemban(new RString(String.valueOf(business.getサービスの状況フラグ連番())));
        row.setServiceJokyoKinyuRemban(new RString(String.valueOf(business.get記入項目連番())));
        row.setShisetsuRiyoFlagRemban(new RString(String.valueOf(business.get施設利用連番())));
    }

    /**
     * 取込むの編集。
     *
     * @param row 認定調査一覧
     * @param entity ＣＳＶデータ
     */
    public void 取込むの編集(dgNinteiChosaData_Row row, ChosaKekkaNyuryokuCsvEntity entity) {

        row.setJyoutai(new RString("変更"));
        row.setShichosonMeisho(entity.getHokenshaName());
        row.setNinteiShinseiYMD(entity.getNinteiShinseiYMD());
        row.setHihokenshaNo(entity.getHihokenshaNo());
        row.setHihokenshaName(entity.getHihokenshaName());
        row.setNinteiShinseiShinseijiKubunCode(entity.getNinteiShinseiShinseijiKubunName());
        row.setNinteichosaIraiKanryoYMD(entity.getNinteichosaIraiKanryoYMD());
        row.setNinteiChosaItakusakiCode(entity.getNinteiChosaItakusakiCode());
        row.setNinteiChosainCode(entity.getNinteiChosainCode());
        row.setNinteichosaJisshiYMD(entity.getNinteichosaJisshiYMD());
        row.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        row.setNinteichosaIraiRirekiNo(entity.getNinteichosaIraiRirekiNo());
        row.setRemban(entity.getResearchItemRemban());
        row.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
        row.setShisetsuRiyoFlag(entity.getShisetsuRiyoFlag());
        row.setServiceJokyoKinyu(entity.getServiceJokyoKinyu());
        row.setServiceJokyo(entity.getServiceJokyo());
        row.setResearchItem(entity.getResearchItem());
        row.setNinchishoNichijoSeikatsuJiritsudoCode(entity.getNinchishoNichijoSeikatsuJiritsudoName());
        row.setShogaiNichijoSeikatsuJiritsudoCode(entity.getShogaiNichijoSeikatsuJiritsudoName());
        row.setNinteichosaTokkijikoNo(entity.getNinteichosaTokkijikoNo());
        row.setNinteichosaTokkijikoRemban(entity.getNinteichosaTokkijikoRemban());
        row.setGaikyoTokkiTextImageKubun(entity.getGaikyoTokkiTextImageKubunName());
        row.setGenponMaskKubun(entity.getGenponMaskKubunName());
        row.setTokkiJiko(entity.getTokkiJiko());
        row.setJutakuKaishu(entity.getJutakuKaishu());
        row.setTokubetsuKyufuService(entity.getTokubetsuKyufuService());
        row.setZaitakuService(entity.getZaitakuService());
        row.setShuso(entity.getShuso());
        row.setKazokuJokyo(entity.getKazokuJokyo());
        row.setKyojuKankyo(entity.getKyojuKankyo());
        row.setKikaiKiki(entity.getKikaiKiki());
        row.setNinteichousaIraiKubunCode(entity.getNinteichousaIraiKubunName());
        row.setNinteichosaIraiKaisu(entity.getNinteichosaIraiKaisu());
        row.setNinteichosaJuryoYMD(entity.getNinteichosaJuryoYMD());
        row.setNinteiChosaKubunCode(entity.getNinteiChosaKubunCode());
        row.setChosaJisshiBashoCode(entity.getChosaJisshiBashoCode());
        row.setChosaJisshiBashoMeisho(entity.getChosaJisshiBashoMeisho());
        row.setServiceKubunCode(entity.getServiceKubunName());
        row.setRiyoShisetsuShimei(entity.getRiyoShisetsuShimei());
        row.setRiyoShisetsuJusho(entity.getRiyoShisetsuJusho());
        row.setRiyoShisetsuTelNo(entity.getRiyoShisetsuTelNo());
        row.setRiyoShisetsuYubinNo(entity.getRiyoShisetsuYubinNo());
        row.setTokki(entity.getTokki());
        row.setTokkijikoUketsukeYMD(entity.getTokkijikoUketsukeYMD());
        row.setTokkijikoJuryoYMD(entity.getTokkijikoJuryoYMD());
        row.setServiceJokyoFlag(entity.getServiceJokyoFlag());
        row.setServiceJokyoRemban(entity.getServiceJokyoRemban());
        row.setServiceJokyoFlagRemban(entity.getServiceJokyoFlagRemban());
        row.setServiceJokyoKinyuRemban(entity.getServiceJokyoKinyuRemban());
        row.setShisetsuRiyoFlagRemban(entity.getShisetsuRiyoFlagRemban());
    }

    /**
     * 取込むの判定。
     *
     * @param row 認定調査一覧
     * @param entity ＣＳＶデータ
     * @return 取込むの判定
     */
    public boolean 取込むの判定(dgNinteiChosaData_Row row, ChosaKekkaNyuryokuCsvEntity entity) {

        return 取込むの判定_1(row, entity) || 取込むの判定_2(row, entity) || 取込むの判定_3(row, entity);
    }

    private boolean 取込むの判定_1(dgNinteiChosaData_Row row, ChosaKekkaNyuryokuCsvEntity entity) {

        return !row.getShichosonMeisho().equals(entity.getHokenshaName())
                || !row.getNinteiShinseiYMD().equals(entity.getNinteiShinseiYMD())
                || !row.getHihokenshaNo().equals(entity.getHihokenshaNo())
                || !row.getHihokenshaName().equals(entity.getHihokenshaName())
                || !row.getNinteiShinseiShinseijiKubunCode().equals(entity.getNinteiShinseiShinseijiKubunName())
                || !row.getNinteichosaIraiKanryoYMD().equals(entity.getNinteichosaIraiKanryoYMD())
                || !row.getNinteiChosaItakusakiCode().equals(entity.getNinteiChosaItakusakiCode())
                || !row.getNinteiChosainCode().equals(entity.getNinteiChosainCode())
                || !row.getNinteichosaJisshiYMD().equals(entity.getNinteichosaJisshiYMD())
                || !row.getShinseishoKanriNo().equals(entity.getShinseishoKanriNo())
                || !row.getNinteichosaIraiRirekiNo().equals(entity.getNinteichosaIraiRirekiNo())
                || !row.getRemban().equals(entity.getResearchItemRemban())
                || !row.getServiceJokyoRemban().equals(entity.getServiceJokyoRemban())
                || !row.getServiceJokyoFlagRemban().equals(entity.getServiceJokyoFlagRemban())
                || !row.getServiceJokyoKinyuRemban().equals(entity.getServiceJokyoKinyuRemban())
                || !row.getShisetsuRiyoFlagRemban().equals(entity.getShisetsuRiyoFlagRemban());
    }

    private boolean 取込むの判定_2(dgNinteiChosaData_Row row, ChosaKekkaNyuryokuCsvEntity entity) {

        return !row.getKoroshoIfShikibetsuCode().equals(entity.getKoroshoIfShikibetsuCode())
                || !row.getShisetsuRiyoFlag().equals(entity.getShisetsuRiyoFlag())
                || !row.getServiceJokyoKinyu().equals(entity.getServiceJokyoKinyu())
                || !row.getServiceJokyo().equals(entity.getServiceJokyo())
                || !row.getResearchItem().equals(entity.getResearchItem())
                || !row.getNinchishoNichijoSeikatsuJiritsudoCode().equals(entity.getNinchishoNichijoSeikatsuJiritsudoName())
                || !row.getShogaiNichijoSeikatsuJiritsudoCode().equals(entity.getShogaiNichijoSeikatsuJiritsudoName())
                || !row.getNinteichosaTokkijikoNo().equals(entity.getNinteichosaTokkijikoNo())
                || !row.getNinteichosaTokkijikoRemban().equals(entity.getNinteichosaTokkijikoRemban())
                || !row.getGaikyoTokkiTextImageKubun().equals(entity.getGaikyoTokkiTextImageKubunName())
                || !row.getGenponMaskKubun().equals(entity.getGenponMaskKubunName())
                || !row.getTokkiJiko().equals(entity.getTokkiJiko())
                || !row.getJutakuKaishu().equals(entity.getJutakuKaishu())
                || !row.getTokubetsuKyufuService().equals(entity.getTokubetsuKyufuService())
                || !row.getZaitakuService().equals(entity.getZaitakuService())
                || !row.getShuso().equals(entity.getShuso())
                || !row.getKazokuJokyo().equals(entity.getKazokuJokyo())
                || !row.getKyojuKankyo().equals(entity.getKyojuKankyo())
                || !row.getKikaiKiki().equals(entity.getKikaiKiki());

    }

    private boolean 取込むの判定_3(dgNinteiChosaData_Row row, ChosaKekkaNyuryokuCsvEntity entity) {

        return !row.getNinteichousaIraiKubunCode().equals(entity.getNinteichousaIraiKubunName())
                || !row.getNinteichosaIraiKaisu().equals(entity.getNinteichosaIraiKaisu())
                || !row.getNinteichosaJuryoYMD().equals(entity.getNinteichosaJuryoYMD())
                || !row.getNinteiChosaKubunCode().equals(entity.getNinteiChosaKubunCode())
                || !row.getChosaJisshiBashoCode().equals(entity.getChosaJisshiBashoCode())
                || !row.getChosaJisshiBashoMeisho().equals(entity.getChosaJisshiBashoMeisho())
                || !row.getServiceKubunCode().equals(entity.getServiceKubunName())
                || !row.getRiyoShisetsuShimei().equals(entity.getRiyoShisetsuShimei())
                || !row.getRiyoShisetsuJusho().equals(entity.getRiyoShisetsuJusho())
                || !row.getRiyoShisetsuTelNo().equals(entity.getRiyoShisetsuTelNo())
                || !row.getRiyoShisetsuYubinNo().equals(entity.getRiyoShisetsuYubinNo())
                || !row.getTokki().equals(entity.getTokki())
                || !row.getTokkijikoUketsukeYMD().equals(entity.getTokkijikoUketsukeYMD())
                || !row.getTokkijikoJuryoYMD().equals(entity.getTokkijikoJuryoYMD())
                || !row.getServiceJokyoFlag().equals(entity.getServiceJokyoFlag());
    }

    /**
     * 選択状態変更の判定。
     *
     * @return 取込むの判定
     */
    public boolean 選択状態変更の判定() {

        List<dgNinteiChosaData_Row> rowList = div.getDgNinteiChosaData().getSelectedItems();
        boolean flg = false;
        for (dgNinteiChosaData_Row row : rowList) {

            if (!RString.isNullOrEmpty(row.getJyoutai())) {

                flg = true;
            }
        }
        return flg;
    }

    /**
     * 認定調査票概況調査の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況調査）
     * @return 認定調査票（概況調査）ビルダー
     */
    public NinteichosahyoGaikyoChosaBuilder 認定調査票概況調査の編集(dgNinteiChosaData_Row row, NinteichosahyoGaikyoChosa entity) {

        NinteichosahyoGaikyoChosaBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set概況調査テキストイメージ区分(TokkijikoTextImageKubun.valueOf(row.
                getGaikyoTokkiTextImageKubun().toString()).getコード());
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        if (!RString.isNullOrEmpty(row.getNinteichousaIraiKubunCode())) {

            builder.set認定調査依頼区分コード(new Code(NinteiChousaIraiKubunCode.
                    valueOf(row.getNinteichousaIraiKubunCode().toString()).getコード()));
        }
        if (!RString.isNullOrEmpty(row.getNinteichosaIraiKaisu())) {

            builder.set認定調査回数(Integer.valueOf(row.getNinteichosaIraiKaisu().toString()));
        }
        if (!RString.isNullOrEmpty(row.getNinteichosaJisshiYMD())) {
            builder.set認定調査実施年月日(toFlexibleDate(row.getNinteichosaJisshiYMD()));
        }
        if (!RString.isNullOrEmpty(row.getNinteichosaJuryoYMD())) {
            builder.set認定調査受領年月日(toFlexibleDate(row.getNinteichosaJuryoYMD()));
        }
        if (!RString.isNullOrEmpty(row.getNinteiChosaKubunCode())) {
            builder.set認定調査区分コード(new Code(row.getNinteiChosaKubunCode()));
        }
        if (!RString.isNullOrEmpty(row.getNinteiChosaItakusakiCode())) {
            builder.set認定調査委託先コード(new JigyoshaNo(row.getNinteiChosaItakusakiCode()));
        }
        builder.set認定調査員コード(row.getNinteiChosainCode());
        if (!RString.isNullOrEmpty(row.getChosaJisshiBashoCode())) {
            builder.set認定調査実施場所コード(new Code(row.getChosaJisshiBashoCode()));
        }
        builder.set認定調査実施場所名称(row.getChosaJisshiBashoMeisho());
        if (!RString.isNullOrEmpty(row.getServiceKubunCode())) {
            builder.set認定調査_サービス区分コード(new Code(ServiceKubunCode.
                    valueOf(row.getServiceKubunCode().toString()).getコード()));
        }
        builder.set利用施設名(row.getRiyoShisetsuShimei());
        if (!RString.isNullOrEmpty(row.getRiyoShisetsuJusho())) {
            builder.set利用施設住所(new AtenaJusho(row.getRiyoShisetsuJusho()));
        }
        if (!RString.isNullOrEmpty(row.getRiyoShisetsuTelNo())) {
            builder.set利用施設電話番号(new TelNo(row.getRiyoShisetsuTelNo()));
        }
        if (!RString.isNullOrEmpty(row.getRiyoShisetsuYubinNo())) {
            builder.set利用施設郵便番号(new YubinNo(row.getRiyoShisetsuYubinNo()));
        }
        builder.set特記(row.getTokki());
        if (!RString.isNullOrEmpty(row.getTokkijikoUketsukeYMD())) {
            builder.set認定調査特記事項受付年月日(toFlexibleDate(row.getTokkijikoUketsukeYMD()));
        }
        if (!RString.isNullOrEmpty(row.getTokkijikoJuryoYMD())) {
            builder.set認定調査特記事項受領年月日(toFlexibleDate(row.getTokkijikoJuryoYMD()));
        }
        return builder;
    }

    /**
     * 認定調査票概況特記の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況特記）
     * @return 認定調査票（概況特記）ビルダー
     */
    public GaikyoTokkiBuilder 認定調査票概況特記の編集(dgNinteiChosaData_Row row, GaikyoTokki entity) {

        GaikyoTokkiBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        if (!RString.isNullOrEmpty(row.getGaikyoTokkiTextImageKubun())) {

            builder.set概況特記テキストイメージ区分(TokkijikoTextImageKubun.valueOf(row.
                    getGaikyoTokkiTextImageKubun().toString()).getコード());
        }
        builder.set住宅改修(row.getJutakuKaishu());
        builder.set市町村特別給付サービス種類名(row.getTokubetsuKyufuService());
        builder.set介護保険給付以外の在宅サービス種類名(row.getZaitakuService());
        builder.set概況特記事項_主訴(row.getShuso());
        builder.set概況特記事項_家族状況(row.getKazokuJokyo());
        builder.set概況特記事項_居住環境(row.getKyojuKankyo());
        builder.set概況特記事項_機器_器械(row.getKikaiKiki());

        return builder;
    }

    /**
     * 認定調査票特記情報の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（特記情報）
     * @return 認定調査票（特記情報）ビルダー
     */
    public NinteichosahyoTokkijikoBuilder 認定調査票特記情報の編集(dgNinteiChosaData_Row row, NinteichosahyoTokkijiko entity) {

        NinteichosahyoTokkijikoBuilder builder = entity.createBuilderForEdit();

        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set認定調査特記事項番号(row.getNinteichosaTokkijikoNo());
        builder.set認定調査特記事項連番(Integer.valueOf(row.getNinteichosaTokkijikoRemban().toString()));
        if (!RString.isNullOrEmpty(row.getGaikyoTokkiTextImageKubun())) {

            builder.set特記事項テキスト_イメージ区分(TokkijikoTextImageKubun.
                    valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード());
        }
        builder.set原本マスク区分(new Code(GenponMaskKubun.valueOf(row.getGenponMaskKubun().toString()).getコード()));
        builder.set特記事項(row.getTokkiJiko());
        return builder;
    }

    /**
     * 認定調査票基本調査の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（基本調査）
     * @return 認定調査票（基本調査）ビルダー
     */
    public NinteichosahyoKihonChosaBuilder 認定調査票基本調査の編集(dgNinteiChosaData_Row row, NinteichosahyoKihonChosa entity) {

        NinteichosahyoKihonChosaBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set要介護認定調査履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set要介護認定調査履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.set認定調査_認知症高齢者の日常生活自立度コード(new Code(NinchishoNichijoSeikatsuJiritsudoCode.
                valueOf(row.getNinchishoNichijoSeikatsuJiritsudoCode().toString()).getコード()));
        builder.set認定調査_障害高齢者の日常生活自立度コード(new Code(ShogaiNichijoSeikatsuJiritsudoCode.
                valueOf(row.getShogaiNichijoSeikatsuJiritsudoCode().toString()).getコード()));
        return builder;
    }

    /**
     * 認定調査票基本調査調査項目の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（基本調査）調査項目
     * @return 認定調査票（基本調査）調査項目ビルダー
     */
    public NinteichosahyoChosaItemBuilder 認定調査票基本調査調査項目の編集(dgNinteiChosaData_Row row, NinteichosahyoChosaItem entity) {

        NinteichosahyoChosaItemBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set要介護認定調査履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set連番(Integer.valueOf(row.getRemban().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.set調査項目(row.getResearchItem());
        return builder;
    }

    /**
     * 認定調査票概況調査サービスの状況の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況調査）サービスの状況
     * @return 認定調査票（概況調査）サービスの状況ビルダー
     */
    public NinteichosahyoServiceJokyoBuilder 認定調査票概況調査サービスの状況の編集(dgNinteiChosaData_Row row, NinteichosahyoServiceJokyo entity) {

        NinteichosahyoServiceJokyoBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set連番(Integer.valueOf(row.getServiceJokyoRemban().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.setサービスの状況(Integer.valueOf(row.getServiceJokyoRemban().toString()));
        return builder;
    }

    /**
     * 認定調査票概況調査サービスの状況フラグの編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況調査）サービスの状況フラグ
     * @return 認定調査票（概況調査）サービスの状況フラグビルダー
     */
    public NinteichosahyoServiceJokyoFlagBuilder 認定調査票概況調査サービスの状況フラグの編集(dgNinteiChosaData_Row row, NinteichosahyoServiceJokyoFlag entity) {

        NinteichosahyoServiceJokyoFlagBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set連番(Integer.valueOf(row.getServiceJokyoFlagRemban().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.setサービスの状況フラグ(Boolean.getBoolean(row.getServiceJokyoFlag().toString()));
        return builder;
    }

    /**
     * 認定調査票概況調査記入項目の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況調査）記入項目
     * @return 認定調査票（概況調査）記入項目ビルダー
     */
    public NinteichosahyoKinyuItemBuilder 認定調査票概況調査記入項目の編集(dgNinteiChosaData_Row row, NinteichosahyoKinyuItem entity) {

        NinteichosahyoKinyuItemBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set連番(Integer.valueOf(row.getServiceJokyoKinyuRemban().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.setサービスの状況記入(row.getServiceJokyoKinyu());
        return builder;
    }

    /**
     * 認定調査票概況調査施設利用の編集。
     *
     * @param row 一覧データ
     * @param entity 認定調査票（概況調査）施設利用
     * @return 認定調査票（概況調査）施設利用ビルダー
     */
    public NinteichosahyoShisetsuRiyoBuilder 認定調査票概況調査施設利用の編集(dgNinteiChosaData_Row row, NinteichosahyoShisetsuRiyo entity) {

        NinteichosahyoShisetsuRiyoBuilder builder = entity.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set連番(Integer.valueOf(row.getShisetsuRiyoFlagRemban().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.set施設利用フラグ(Boolean.getBoolean(row.getShisetsuRiyoFlag().toString()));
        return builder;
    }

    private FlexibleDate toFlexibleDate(RString obj) {
        if (obj == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(new RDate(obj.toString()).toDateString());
    }
}
