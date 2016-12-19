/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2060001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbe.definition.core.KanryoShoriStatus;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.ChosaInputCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.NinteichosaKekkaNyushuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosairailist.NinteichosaIraiListManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.CyoSaNyuSyuBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteichosaTokusokuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteitasklist.YokaigoNinteiTaskListFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 完了処理・認定調査結果入手のHandlerクラスです。
 *
 * @reamsid_L DBE-0310-010 dingyi
 */
public class NinteichosaKekkaNyushuHandler {

    private final NinteichosaKekkaNyushuDiv div;
    private static final RString 使用する = new RString("1");
    private static final RString 調査結果を登録するボタン = new RString("btnKekkaTouroku");
    private static final RString 調査票入手を完了するボタン = new RString("btnChousaResultKanryo");

    /**
     * コンストラクタです。
     *
     * @param div 完了処理・認定調査結果入手Div
     */
    public NinteichosaKekkaNyushuHandler(NinteichosaKekkaNyushuDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・認定調査結果入手に初期化を設定します。
     */
    public void onLoad() {
        setRadJotaiKubun();
        initialDataGrid();
        setCommonButtonState();
        RString モバイル調査使用有無 = DbBusinessConfig.get(ConfigNameDBE.モバイル調査使用有無, RDate.getNowDate());
        if (使用する.equals(モバイル調査使用有無)) {
            div.getBtncyosakekkainput().setDisabled(false);
        } else {
            div.getBtncyosakekkainput().setDisabled(true);
        }
    }

    /**
     * 「モバイルデータを取込む」ボタンを押下する場合、ファイルを読み込み処理を実行します。
     *
     * @param csvEntityList ＣＳＶからデータリスト
     */
    public void onClick_btnCyosakekkaInput(List<ChosaInputCsvEntity> csvEntityList) {
        saveCsvDataInput(csvEntityList);
    }

    /**
     * 「調査票入手を完了する」ボタンを押下する場合、ＤＢに更新する処理を実行します。
     *
     * @param 要介護認定完了情報Model 要介護認定完了情報Model
     */
    public void onClick_btnChousaResultKanryo(Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> 要介護認定完了情報Model) {
        List<dgNinteiTaskList_Row> 選択されたデータ = div.getNinteichosakekkainput().getDgNinteiTaskList().getSelectedItems();
        for (dgNinteiTaskList_Row row : 選択されたデータ) {
            NinteiKanryoJohoIdentifier 要介護認定完了情報の識別子 = new NinteiKanryoJohoIdentifier(
                    new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            NinteichosaIraiListManager.createInstance().save要介護認定完了情報(要介護認定完了情報Model.get(要介護認定完了情報の識別子).
                    createBuilderForEdit().set認定調査完了年月日(FlexibleDate.getNowDate()).build().toEntity());
        }
    }

    /**
     * 対象者一覧グリッドに対象者を設定します。
     */
    public void initialDataGrid() {
        List<CyoSaNyuSyuBusiness> 調査入手List = YokaigoNinteiTaskListFinder.createInstance().
                get調査入手モード(YokaigoNinteiTaskListParameter.
                        createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
        if (!調査入手List.isEmpty()) {
            ShinSaKaiBusiness 前調査入手Model = YokaigoNinteiTaskListFinder.createInstance().
                    get前調査入手モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前調査入手Model.get要介護認定完了情報Lsit()));
        } else {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
        }
        setDataGrid(調査入手List);
    }

    /**
     * 共通ボタンの制御を行います。
     */
    public void setCommonButtonState() {
        if (KanryoShoriStatus.未処理.getコード().equals(div.getNinteichosakekkainput().getRadJotaiKubun().getSelectedKey())) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査結果を登録するボタン, false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査票入手を完了するボタン, true);
        } else if (KanryoShoriStatus.完了可能.getコード().equals(div.getNinteichosakekkainput().getRadJotaiKubun().getSelectedKey())) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査結果を登録するボタン, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査票入手を完了するボタン, false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査結果を登録するボタン, false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査票入手を完了するボタン, false);
        }
    }

    private void setRadJotaiKubun() {
        RString config = DbBusinessConfig.get(ConfigNameDBE.基本運用_対象者一覧表示区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (RString.isNullOrEmpty(config)) {
            div.getNinteichosakekkainput().getRadJotaiKubun().setSelectedKey(KanryoShoriStatus.すべて.getコード());
        } else {
            div.getNinteichosakekkainput().getRadJotaiKubun().setSelectedKey(config);
        }
    }

    private void setDataGrid(List<CyoSaNyuSyuBusiness> 調査入手List) {
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int mishoriCount = 0;
        int kanryoKanoCount = 0;
        for (CyoSaNyuSyuBusiness business : 調査入手List) {
            if (!isDisplay(business.get認定調査実施年月日())) {
                continue;
            }

            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();

            row.setHokensha(RString.isNullOrEmpty(business.get保険者名()) ? RString.EMPTY : business.get保険者名());
            if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
                row.getNinteiShinseiYMD().setValue(new RDate(business.get認定申請年月日().toString()));
            }
            row.setHihoNo(RString.isNullOrEmpty(business.get被保険者番号()) ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei((business.get氏名() == null || RString.isNullOrEmpty(business.get氏名().value()))
                    ? RString.EMPTY : business.get氏名().value());
            row.setShinseiKubunShinseiji((business.get認定申請区分申請時コード() == null || RString.isNullOrEmpty(business.get認定申請区分申請時コード().getKey()))
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            if (business.get認定調査依頼完了年月日() != null && !business.get認定調査依頼完了年月日().isEmpty()) {
                row.getChosaIraiKanryoYMD().setValue(new RDate(business.get認定調査依頼完了年月日().toString()));
            }
            row.setChosaItakusaki(RString.isNullOrEmpty(business.get調査委託先()) ? RString.EMPTY : business.get調査委託先());
            row.setChosain(RString.isNullOrEmpty(business.get調査員氏名()) ? RString.EMPTY : business.get調査員氏名());
            if (business.get認定調査実施年月日() != null && !business.get認定調査実施年月日().isEmpty()) {
                row.getChosaJisshiYMD().setValue(new RDate(business.get認定調査実施年月日().toString()));
                row.setJotai(KanryoShoriStatus.完了可能.get略称());
                kanryoKanoCount++;
            } else {
                row.setJotai(KanryoShoriStatus.未処理.get略称());
                row.setCellBgColor("jotai", DataGridCellBgColor.bgColorRed);
                mishoriCount++;
            }
            if (business.get認定調査督促年月日() != null && !business.get認定調査督促年月日().isEmpty()) {
                row.getTokusokuHakkoYMD().setValue(new RDate(business.get認定調査督促年月日().toString()));
            }
            row.setTokusokuHoho(RString.isNullOrEmpty(business.get認定調査督促方法())
                    ? RString.EMPTY : new RString(NinteichosaTokusokuHoho.toValue(business.get認定調査督促方法()).name()));
            row.getTokusokuKaisu().setValue(new Decimal(business.get認定調査督促回数()));
            if (business.get認定調査期限年月日() != null && !business.get認定調査期限年月日().isEmpty()) {
                row.getTokusokuKigen().setValue(new RDate(business.get認定調査期限年月日().toString()));
            }
            row.setTokusokuChiku(RString.isNullOrEmpty(business.get地区コード()) ? RString.EMPTY
                    : CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                            DBECodeShubetsu.調査地区コード.getコード(),
                            new Code(business.get地区コード()), new FlexibleDate(RDate.getNowDate().toDateString())));
            row.setChosaItakusakiCode(business.get認定調査委託先コード() == null || RString.isNullOrEmpty(business.get認定調査委託先コード().value())
                    ? RString.EMPTY : business.get認定調査委託先コード().value());
            row.setChosainCode((business.get調査員コード() == null || RString.isNullOrEmpty(business.get調査員コード().value()))
                    ? RString.EMPTY : business.get調査員コード().value());
            row.setChikuCode(RString.isNullOrEmpty(business.get地区コード()) ? RString.EMPTY : business.get地区コード());
            row.setShinseishoKanriNo((business.get申請書管理番号() == null || RString.isNullOrEmpty(business.get申請書管理番号().value()))
                    ? RString.EMPTY : business.get申請書管理番号().value());
            row.setNinteichosaIraiRirekiNo(new RString(business.get認定調査依頼履歴番号()));

            rowList.add(row);
        }
        div.getTxtMishori().setValue(new Decimal(mishoriCount));
        div.getTxtKanryoKano().setValue(new Decimal(kanryoKanoCount));
        div.getTxtGokei().setValue(new Decimal(mishoriCount + kanryoKanoCount));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private boolean isDisplay(FlexibleDate 認定調査実施日) {
        if (KanryoShoriStatus.未処理.getコード().equals(div.getNinteichosakekkainput().getRadJotaiKubun().getSelectedKey())) {
            return 認定調査実施日 == null || 認定調査実施日.isEmpty();

        } else if (KanryoShoriStatus.完了可能.getコード().equals(div.getNinteichosakekkainput().getRadJotaiKubun().getSelectedKey())) {
            return 認定調査実施日 != null && !認定調査実施日.isEmpty();
        }
        return true;
    }

    private void saveCsvDataInput(List<ChosaInputCsvEntity> csvEntityList) {
        for (ChosaInputCsvEntity csvEntity : csvEntityList) {
            NinteichosahyoGaikyoChosa 認定調査票概況調査 = set認定調査票概況調査(csvEntity);
            GaikyoTokki 認定調査票概況特記 = set認定調査票概況特記(csvEntity);
            NinteichosahyoTokkijiko 認定調査票特記情報 = set認定調査票特記情報(csvEntity);
            NinteichosahyoKihonChosa 認定調査票基本調査 = set認定調査票基本調査(csvEntity);
            NinteichosahyoChosaItem 認定調査票基本調査調査項目 = set認定調査票基本調査調査項目(csvEntity);
            NinteichosahyoServiceJokyo 認定調査票概況調査サービスの状況 = set認定調査票概況調査サービスの状況(csvEntity);
            NinteichosahyoServiceJokyoFlag 認定調査票概況調査サービスの状況フラグ = set認定調査票概況調査サービスの状況フラグ(csvEntity);
            NinteichosahyoKinyuItem 認定調査票概況調査記入項目 = set認定調査票概況調査記入項目(csvEntity);
            NinteichosahyoShisetsuRiyo 認定調査票概況調査施設利用 = set認定調査票概況調査施設利用(csvEntity);
            NinteichosaIraiListManager.createInstance().saveCsvDataInput(
                    認定調査票概況調査,
                    認定調査票概況特記,
                    認定調査票特記情報,
                    認定調査票基本調査,
                    認定調査票基本調査調査項目,
                    認定調査票概況調査サービスの状況,
                    認定調査票概況調査サービスの状況フラグ,
                    認定調査票概況調査記入項目,
                    認定調査票概況調査施設利用);
        }
    }

    private NinteichosahyoGaikyoChosa set認定調査票概況調査(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoGaikyoChosa 認定調査票概況調査 = new NinteichosahyoGaikyoChosa(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                csvEntity.getGaikyoChosaTextImageKubun());
        return 認定調査票概況調査.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                set認定調査依頼区分コード(new Code(csvEntity.getNinteichousaIraiKubunCode())).
                set認定調査回数(Integer.parseInt(csvEntity.getNinteichosaIraiKaisu().toString())).
                set認定調査実施年月日(dateFormart(csvEntity.getNinteichosaJisshiYMD())).
                set認定調査受領年月日(dateFormart(csvEntity.getNinteichosaJuryoYMD())).
                set認定調査区分コード(new Code(csvEntity.getNinteiChosaKubunCode())).
                set認定調査委託先コード(new JigyoshaNo(csvEntity.getNinteiChosaItakusakiCode())).
                set認定調査員コード(csvEntity.getNinteiChosainCode()).
                set認定調査実施場所コード(Code.EMPTY).
                set認定調査実施場所名称(csvEntity.getChosaJisshiBashoMeisho()).
                set認定調査_サービス区分コード(new Code(csvEntity.getServiceKubunCode())).
                set利用施設名(csvEntity.getRiyoShisetsuShimei()).
                set利用施設住所(new AtenaJusho(csvEntity.getRiyoShisetsuJusho())).
                set利用施設電話番号(new TelNo(csvEntity.getRiyoShisetsuTelNo())).
                set利用施設郵便番号(new YubinNo(csvEntity.getRiyoShisetsuYubinNo())).
                set特記(csvEntity.getTokki()).
                set認定調査特記事項受付年月日(dateFormart(csvEntity.getTokkijikoUketsukeYMD())).
                set認定調査特記事項受領年月日(dateFormart(csvEntity.getTokkijikoJuryoYMD())).
                build();
    }

    private GaikyoTokki set認定調査票概況特記(ChosaInputCsvEntity csvEntity) {
        GaikyoTokki 認定調査票概況特記 = new GaikyoTokki(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                csvEntity.getGaikyoChosaTextImageKubun());
        return 認定調査票概況特記.createBuilderForEdit().
                set住宅改修(csvEntity.getJutakuKaishu()).
                set市町村特別給付サービス種類名(csvEntity.getTokubetsuKyufuService()).
                set介護保険給付以外の在宅サービス種類名(csvEntity.getZaitakuService()).
                set概況特記事項_主訴(csvEntity.getShuso()).
                set概況特記事項_家族状況(csvEntity.getKazokuJokyo()).
                set概況特記事項_居住環境(csvEntity.getKyojuKankyo()).
                set概況特記事項_機器_器械(csvEntity.getKikaiKiki()).
                build();
    }

    private NinteichosahyoTokkijiko set認定調査票特記情報(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoTokkijiko 認定調査票特記情報 = new NinteichosahyoTokkijiko(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                csvEntity.getNinteichosaTokkijikoNo(),
                Integer.parseInt(csvEntity.getNinteichosaTokkijikoRemban().toString()),
                csvEntity.getGaikyoChosaTextImageKubun(),
                new Code(csvEntity.getGenponMaskKubun()));
        return 認定調査票特記情報.createBuilderForEdit().
                set特記事項(使用する).
                build();
    }

    private NinteichosahyoKihonChosa set認定調査票基本調査(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoKihonChosa 認定調査票基本調査 = new NinteichosahyoKihonChosa(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()));
        return 認定調査票基本調査.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                set認定調査_認知症高齢者の日常生活自立度コード(new Code(csvEntity.getNinchishoNichijoSeikatsuJiritsudoCode())).
                set認定調査_障害高齢者の日常生活自立度コード(new Code(csvEntity.getShogaiNichijoSeikatsuJiritsudoCode())).
                build();
    }

    private NinteichosahyoChosaItem set認定調査票基本調査調査項目(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoChosaItem 認定調査票基本調査調査項目 = new NinteichosahyoChosaItem(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                Integer.parseInt(csvEntity.getResearchItemRemban().toString()));
        return 認定調査票基本調査調査項目.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                set調査項目(csvEntity.getResearchItem()).
                build();
    }

    private NinteichosahyoServiceJokyo set認定調査票概況調査サービスの状況(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoServiceJokyo 認定調査票概況調査サービスの状況 = new NinteichosahyoServiceJokyo(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                Integer.parseInt(csvEntity.getServiceJokyoRemban().toString()));
        return 認定調査票概況調査サービスの状況.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                setサービスの状況(Integer.parseInt(csvEntity.getServiceJokyo().toString())).
                build();
    }

    private NinteichosahyoServiceJokyoFlag set認定調査票概況調査サービスの状況フラグ(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoServiceJokyoFlag 認定調査票概況調査サービスの状況フラグ = new NinteichosahyoServiceJokyoFlag(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                Integer.parseInt(csvEntity.getServiceJokyoFlagRemban().toString()));
        return 認定調査票概況調査サービスの状況フラグ.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                setサービスの状況フラグ(Boolean.getBoolean(csvEntity.getServiceJokyoFlag().toString())).
                build();
    }

    private NinteichosahyoKinyuItem set認定調査票概況調査記入項目(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoKinyuItem 認定調査票概況調査サービスの状況フラグ = new NinteichosahyoKinyuItem(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                Integer.parseInt(csvEntity.getServiceJokyoKinyuRemban().toString()));
        return 認定調査票概況調査サービスの状況フラグ.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                setサービスの状況記入(csvEntity.getServiceJokyoKinyu()).
                build();
    }

    private NinteichosahyoShisetsuRiyo set認定調査票概況調査施設利用(ChosaInputCsvEntity csvEntity) {
        NinteichosahyoShisetsuRiyo 認定調査票概況調査施設利用 = new NinteichosahyoShisetsuRiyo(
                new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()),
                Integer.parseInt(csvEntity.getNinteichosaIraiRirekiNo().toString()),
                Integer.parseInt(csvEntity.getShisetsuRiyoFlagRemban().toString()));
        return 認定調査票概況調査施設利用.createBuilderForEdit().
                set厚労省IF識別コード(new Code(csvEntity.getKoroshoIfShikibetsuCode())).
                set施設利用フラグ(Boolean.getBoolean(csvEntity.getShisetsuRiyoFlag().toString())).
                build();
    }

    private FlexibleDate dateFormart(RString 年月日) {
        return RString.isNullOrEmpty(年月日) ? FlexibleDate.EMPTY : new FlexibleDate(new RDate(年月日.toString()).toDateString());
    }

}
