/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4050001;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.imagejohomasking.ImageJohoMaskingResult;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imagejohomasking.ImageJohoMaskingParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.ImageJohoMaskingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.dgImageMaskShoriTaishosha_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.dgImageMaskingTaisho_Row;
import jp.co.ndensan.reams.db.dbe.service.core.imagejohomasking.ImageJohoMaskingFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoChosaTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoChosaTokkiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IkenshoImageJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IkenshoImageJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.GaikyoChosaTokkiManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.IkenshoImageJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedAppendOption;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * イメージ情報マスキングの抽象Handlerクラスです。
 *
 * @reamsid_L DBE-1620-010 chengsanyuan
 */
public class ImageJohoMaskingHandler {

    private final ImageJohoMaskingDiv div;
    private IkenshoImageJohoManager imageJohoManager;
    private NinteichosahyoTokkijikoManager tokkijikoManager;
    private GaikyoChosaTokkiManager gaikyoManager;
    private static final int 特記事項連番開始位置 = 10;
    private static final int 特記事項連番終了位置 = 8;
    private static final int 意見書_表ページ = 1;
    private static final int 意見書_裏ページ = 2;
    private static final RString ALL_SHICHOSON_KEY = new RString("000000");
    private static final RString 状態_削除作業用 = new RString("削除");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString イメージファイル終端 = new RString(".png");
    private static final RString BAKファイル終端 = new RString("_BAK.png");
    private static final RString 編集後ファイル終端 = new RString("_NEW.png");
    private static final RString ローカルファイル名 = new RString("IMG");
    private static RString outputImagePath;
    private static RString imagePath;
    private static dgImageMaskShoriTaishosha_Row taishoshaRow;
    private static ImageJohoMaskingParameter param;

    /**
     * コンストラクタです。
     *
     * @param div イメージ情報マスキングDiv
     */
    public ImageJohoMaskingHandler(ImageJohoMaskingDiv div) {
        this.div = div;
    }

    /**
     * 初期表示を行います
     */
    public void 初期表示() {
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTxtMaxDisp().setValue(new Decimal(最大表示件数.toString()));
        div.getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
    }

    /**
     * 検索用パラメーターを設定します
     *
     * @param shinseishoKanriNoList 申請書管理番号のリスト
     */
    public void set検索用パラメーター(ShinseishoKanriNoList shinseishoKanriNoList) {
        param = ImageJohoMaskingParameter.createImageJohoMaskingParameter(
                shinseishoKanriNoList != null ? LasdecCode.EMPTY : div.getCcdHokensya().getSelectedItem().get市町村コード(),
                shinseishoKanriNoList != null ? FlexibleDate.MAX : div.getTxtSearchStYMD().getValue(),
                shinseishoKanriNoList != null ? FlexibleDate.MAX : div.getTxtSearchEdYMD().getValue(),
                shinseishoKanriNoList != null ? RString.EMPTY : div.getDdlKensakuTaisho().getSelectedKey(),
                shinseishoKanriNoList != null ? shinseishoKanriNoList.getShinseishoKanriNoS() : null,
                shinseishoKanriNoList != null ? RString.EMPTY : div.getTxtHihokenshaNumber().getValue(),
                div.getTxtMaxDisp().getValue());
    }

    /**
     * 設定したパラメーターを用いて対象者のリストを作成します
     *
     * @return マスキング対象者のリスト
     */
    public List<ImageJohoMaskingResult> get対象者() {
        return ImageJohoMaskingFinder.createInstance().getDataForLoad(param).records();
    }

    /**
     * マスク処理対象者のデータを画面に設定します。
     *
     * @param resultList マスク処理対象者
     */
    public void setDataGrid(List<ImageJohoMaskingResult> resultList) {
        List<dgImageMaskShoriTaishosha_Row> rowList = new ArrayList<>();
        for (ImageJohoMaskingResult result : resultList) {
            dgImageMaskShoriTaishosha_Row row = new dgImageMaskShoriTaishosha_Row();
            row.set保険者(result.get証記載保険者番号());
            row.set被保番号(result.get被保険者番号());
            row.set氏名(result.get被保険者氏名().value());
            row.get申請日().setValue(result.get認定申請年月日());
            try {
                row.set申請区分(NinteiShinseiShinseijiKubunCode.toValue(result.get認定申請区分_申請時コード().value()).get名称());
            } catch (IllegalArgumentException e) {
                row.set申請区分(RString.EMPTY);
            }
            row.get審査予定日().setValue(result.get介護認定審査会開催予定年月日());

            if (result.has概況マスク()) {
                row.set調査票(new RString("○"));
            } else {
                row.set調査票(RString.EMPTY);
            }
            if (result.has特記マスク()) {
                row.set調査票特記(new RString("○"));
            } else {
                row.set調査票特記(RString.EMPTY);
            }
            if (result.has意見書マスク()) {
                row.set主治医意見(new RString("○"));
            } else {
                row.set主治医意見(RString.EMPTY);
            }
            row.get意見書受領日().setValue(result.get主治医意見書受領年月日());
            row.get調査票受領日().setValue(result.get認定調査受領年月日());
            row.set申請書管理番号(result.get申請書管理番号().value());
            row.set認定調査依頼履歴番号(new RString(result.get認定調査依頼履歴番号()));
            row.set主治医意見書作成依頼履歴番号(new RString(result.get主治医意見書作成依頼履歴番号()));
            if (result.get帳票ID() == null) {
                row.set帳票ID(RString.EMPTY);
            } else {
                row.set帳票ID(result.get帳票ID().value());
            }
            if (result.getイメージ共有ファイルID() != null) {
                row.set共有ファイルID(new RString(result.getイメージ共有ファイルID().toString()));
            }
            row.set認定申請年(new RString(result.get認定申請年()));
            setアクセスログ(result.get申請書管理番号().value());
            rowList.add(row);
        }
        div.getDgImageMaskShoriTaishosha().setDataSource(rowList);
    }

    /**
     * 検索条件入力値をクリアする
     */
    public void clear() {
        div.getTxtHihokenshaNumber().clearValue();
        div.getCcdHokensya().setSelectedShichosonIfExist(new LasdecCode(ALL_SHICHOSON_KEY));
        div.getDdlKensakuTaisho().setSelectedIndex(0);
        div.getTxtSearchStYMD().clearValue();
        div.getTxtSearchEdYMD().clearValue();
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTxtMaxDisp().setValue(new Decimal(最大表示件数.toString()));
    }

    /**
     * イメージ情報パネルの設定
     */
    public void setMeisai() {

        taishoshaRow = div.getDgImageMaskShoriTaishosha().getClickedItem();
        outputImagePath = Directory.createTmpDirectory();
        imagePath = Path.combinePath(outputImagePath, ローカルファイル名);

        div.getCcdNinteiShinseishaKihonInfo().initialize(new ShinseishoKanriNo(taishoshaRow.get申請書管理番号()));

        RString ファイル名 = taishoshaRow.get保険者().concat(taishoshaRow.get被保番号());
        RDateTime 共有ファイルID = RDateTime.parse(taishoshaRow.get共有ファイルID().toString());
        ReadOnlySharedFileEntryDescriptor descriptor = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(ファイル名), 共有ファイルID);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(outputImagePath));
        } catch (Exception ex) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        }
        File file = new File(imagePath.toString());
        if (file.exists()) {
            setMaskingTaisho(file);
        }
    }

    private void setMaskingTaisho(File file) {
        List<dgImageMaskingTaisho_Row> rowList = new ArrayList<>();
        String[] files = file.list();
        if (files.length == 0) {
            return;
        }
        for (String imageFile : files) {
            dgImageMaskingTaisho_Row row = new dgImageMaskingTaisho_Row();
            row.setImageName(new RString(imageFile));
            row.setImagePath(imagePath.concat(new RString("\\")).concat(new RString(imageFile)));
            rowList.add(row);
        }

        for (int i = 0; i < rowList.size(); i++) {
            dgImageMaskingTaisho_Row 検索対象 = rowList.get(i);
            for (int j = 0; j < rowList.size(); j++) {
                dgImageMaskingTaisho_Row 検索用 = rowList.get(j);
                RString 比較用ファイル名 = 検索対象.getImageName().replace(new RString(".png"), new RString("_BAK.png"));
                if (検索用.getImageName().equals(比較用ファイル名)) {
                    検索対象.setHasMask(new RString("有"));
                    検索対象.setMaskImagePath(検索対象.getImagePath());
                    検索対象.setImagePath(検索用.getImagePath());
                    検索用.setState(状態_削除作業用);
                }
            }
        }

        for (int i = 0; i < rowList.size(); i++) {
            dgImageMaskingTaisho_Row 検索対象 = rowList.get(i);
            if (!検索対象.getState().equals(状態_削除作業用)) {
                RString 日本語名称 = マスク有りイメージ一覧.getEnumToImageName(検索対象.getImageName()).getイメージ日本語名称();
                if (日本語名称.isEmpty()) {
                    検索対象.setState(状態_削除作業用);
                } else {
                    検索対象.setImageName(日本語名称);
                }
            }
        }

        for (int i = rowList.size() - 1; i >= 0; i--) {
            dgImageMaskingTaisho_Row 検索対象 = rowList.get(i);
            if (検索対象.getState().equals(状態_削除作業用)) {
                rowList.remove(i);
            }
        }

        div.getDgImageMaskingTaisho().setDataSource(rowList);
    }

    /**
     * 今回編集したマスキングデータを削除いたします
     */
    public void deleteEditedData() {
        dgImageMaskingTaisho_Row row = div.getDgImageMaskingTaisho().getActiveRow();
        new File(row.getEditImagePath().toString()).delete();
        row.setEditImagePath(RString.EMPTY);
        row.setState(RString.EMPTY);
        if (row.getMaskImagePath().isEmpty()) {
            row.setHasMask(RString.EMPTY);
        }
    }

    /**
     * マスキングデータ保存時にデータグリッドを更新します
     *
     * @param newImagePath 編集したマスキングデータのパス
     */
    public void row更新(RString newImagePath) {
        dgImageMaskingTaisho_Row row = div.getDgImageMaskingTaisho().getActiveRow();
        row.setEditImagePath(newImagePath);
        if (row.getMaskImagePath().isEmpty()) {
            row.setState(状態_追加);
        } else {
            row.setState(状態_修正);
        }
    }

    /**
     * マスキングデータの保存を行います
     */
    public void 更新処理() {
        imageJohoManager = IkenshoImageJohoManager.createInstance();
        tokkijikoManager = NinteichosahyoTokkijikoManager.createInstance();
        gaikyoManager = GaikyoChosaTokkiManager.createInstance();
        for (dgImageMaskingTaisho_Row row : div.getDgImageMaskingTaisho().getDataSource()) {
            if (!RString.isNullOrEmpty(row.getState())) {
                saveLocalFile(row);
                saveGamenData(row);
                saveSharedFile(row);
            }
        }
        taishoshaRow = null;
    }

    private void saveSharedFile(dgImageMaskingTaisho_Row row) {
        RString ファイル名 = taishoshaRow.get保険者().concat(taishoshaRow.get被保番号());
        RDateTime 共有ファイルID = RDateTime.parse(taishoshaRow.get共有ファイルID().toString());
        ReadOnlySharedFileEntryDescriptor descriptor = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(ファイル名), 共有ファイルID);
        SharedAppendOption option = new SharedAppendOption();
        option.overWrite(true);
        SharedFile.appendNewFile(descriptor, new FilesystemPath(row.getImagePath()), ローカルファイル名.toString(), option);
        SharedFile.appendNewFile(descriptor, new FilesystemPath(row.getEditImagePath()), ローカルファイル名.toString(), option);
    }

    private void saveLocalFile(dgImageMaskingTaisho_Row row) {

        File newFile = new File(row.getEditImagePath().toString());
        File saveFile = new File(row.getEditImagePath().replace(編集後ファイル終端, イメージファイル終端).toString());
        if (row.getState().equals(状態_追加)) {
            File genponFile = new File(row.getImagePath().toString());
            File renameFile = new File(row.getImagePath().replace(イメージファイル終端, BAKファイル終端).toString());
            genponFile.renameTo(renameFile);
            row.setImagePath(new RString(renameFile.getPath()));
        } else if (row.getState().equals(状態_修正)) {
            File maskFile = new File(row.getMaskImagePath().toString());
            maskFile.delete();
        }
        newFile.renameTo(saveFile);
        row.setEditImagePath(new RString(saveFile.getPath()));
    }

    private void saveGamenData(dgImageMaskingTaisho_Row row) {
        if (row.getState().equals(状態_追加)) {
            if (row.getImageName().equals(マスク有りイメージ一覧.C0007.getイメージ日本語名称())) {
                GaikyoChosaTokki gaikyotokki = new GaikyoChosaTokki(new ShinseishoKanriNo(taishoshaRow.get申請書管理番号()),
                        Integer.parseInt(taishoshaRow.get認定調査依頼履歴番号().toString()),
                        TokkijikoTextImageKubun.イメージ.getコード());

                GaikyoChosaTokkiBuilder builder = gaikyotokki.createBuilderForEdit();

                builder.set特記(RString.EMPTY);

                gaikyoManager.save概況調査特記(builder.build());
            } else if (row.getImageName().equals(マスク有りイメージ一覧.E0001.getイメージ日本語名称())
                    || row.getImageName().equals(マスク有りイメージ一覧.E0002.getイメージ日本語名称())) {

                IkenshoImageJoho imageJoho = new IkenshoImageJoho(
                        new ShinseishoKanriNo(taishoshaRow.get申請書管理番号()),
                        Integer.parseInt(taishoshaRow.get主治医意見書作成依頼履歴番号().toString()),
                        new Code(taishoshaRow.get帳票ID()), GenponMaskKubun.マスク.getコード(),
                        row.getImageName().equals(マスク有りイメージ一覧.E0001.getイメージ日本語名称()) ? 意見書_表ページ : 意見書_裏ページ);

                IkenshoImageJohoBuilder builder = imageJoho.createBuilderForEdit();

//                builder.set認定申請年(Integer.parseInt(taishoshaRow.get認定申請年().toString()));
//                builder.set共有ファイルID(RDateTime.parse(taishoshaRow.get共有ファイルID().toString()));
                imageJohoManager.save要介護認定意見書イメージ情報(builder.build());

            } else if (マスク有りイメージ一覧.getEnumToName(row.getImageName()).get特記事項番号() != null
                    && !マスク有りイメージ一覧.getEnumToName(row.getImageName()).get特記事項番号().isEmpty()) {
                int 連番 = Integer.parseInt(row.getEditImagePath().substring(row.getEditImagePath().length() - 特記事項連番開始位置, row.getEditImagePath().length() - 特記事項連番終了位置).toString()) + 1;
                NinteichosahyoTokkijiko tokkijiko = new NinteichosahyoTokkijiko(
                        new ShinseishoKanriNo(taishoshaRow.get申請書管理番号()),
                        Integer.parseInt(taishoshaRow.get認定調査依頼履歴番号().toString()),
                        マスク有りイメージ一覧.getEnumToName(row.getImageName()).get特記事項番号(),
                        連番,
                        TokkijikoTextImageKubun.イメージ.getコード(),
                        new Code(GenponMaskKubun.マスク.getコード()));

                NinteichosahyoTokkijikoBuilder builder = tokkijiko.createBuilderForEdit();

                builder.set特記事項(RString.EMPTY);

                tokkijikoManager.save認定調査票_特記情報(builder.build());
            }
        }
    }

    /**
     * 選択された列に応じてボタンの制御を変更します
     */
    public void ボタン制御() {
        dgImageMaskingTaisho_Row row = div.getDgImageMaskingTaisho().getActiveRow();
        div.getBtnMaskingGenpon().setDisabled(false);
        if (row.getHasMask().equals(new RString("有")) || !row.getState().isEmpty()) {
            div.getBtnMaskingMask().setDisabled(false);
        } else {
            div.getBtnMaskingMask().setDisabled(true);
        }
        if (!row.getState().isEmpty()) {
            div.getBtnTorikeshi().setDisabled(false);
        } else {
            div.getBtnTorikeshi().setDisabled(true);
        }
    }

    public void ボタンsetDisabled() {
        div.getBtnMaskingGenpon().setDisabled(true);
        div.getBtnMaskingMask().setDisabled(true);
        div.getBtnTorikeshi().setDisabled(true);
    }

    private void setアクセスログ(RString 申請書管理番号) {
        AccessLogger.log(AccessLogType.照会, PersonalData.of(ShikibetsuCode.EMPTY,
                new ExpandedInformation(new Code("0001"),
                        new RString("申請書管理番号"), 申請書管理番号)));

    }

    private enum マスク有りイメージ一覧 {

        C0007("C0007.png", "特記事項", ""),
        C3001("C3001.png", "特記1-1", "101"),
        C3006("C3006.png", "特記1-2", "102"),
        C3010("C3010.png", "特記1-3", "103"),
        C3011("C3011.png", "特記1-4", "104"),
        C3012("C3012.png", "特記1-5", "105"),
        C3013("C3013.png", "特記1-6", "106"),
        C3014("C3014.png", "特記1-7", "107"),
        C3015("C3015.png", "特記1-8", "108"),
        C3016("C3016.png", "特記1-9", "109"),
        C3017("C3017.png", "特記1-10", "110"),
        C3018("C3018.png", "特記1-11", "111"),
        C3019("C3019.png", "特記1-12", "112"),
        C3020("C3020.png", "特記1-13", "113"),
        C3021("C3021.png", "特記2-1", "201"),
        C3022("C3022.png", "特記2-2", "202"),
        C3023("C3023.png", "特記2-3", "203"),
        C3024("C3024.png", "特記2-4", "204"),
        C3025("C3025.png", "特記2-5", "205"),
        C3026("C3026.png", "特記2-6", "206"),
        C3027("C3027.png", "特記2-7", "207"),
        C3028("C3028.png", "特記2-8", "208"),
        C3029("C3029.png", "特記2-9", "209"),
        C3030("C3030.png", "特記2-10", "210"),
        C3031("C3031.png", "特記2-11", "211"),
        C3032("C3032.png", "特記2-12", "212"),
        C3033("C3033.png", "特記3-1", "301"),
        C3034("C3034.png", "特記3-2", "302"),
        C3035("C3035.png", "特記3-3", "303"),
        C3036("C3036.png", "特記3-4", "304"),
        C3037("C3037.png", "特記3-5", "305"),
        C3038("C3038.png", "特記3-6", "306"),
        C3039("C3039.png", "特記3-7", "307"),
        C3040("C3040.png", "特記3-8", "308"),
        C3041("C3041.png", "特記3-9", "309"),
        C3042("C3042.png", "特記4-1", "401"),
        C3043("C3043.png", "特記4-2", "402"),
        C3044("C3044.png", "特記4-3", "403"),
        C3045("C3045.png", "特記4-4", "404"),
        C3046("C3046.png", "特記4-5", "405"),
        C3047("C3047.png", "特記4-6", "406"),
        C3048("C3048.png", "特記4-7", "407"),
        C3049("C3049.png", "特記4-8", "408"),
        C3050("C3050.png", "特記4-9", "409"),
        C3051("C3051.png", "特記4-10", "410"),
        C3052("C3052.png", "特記4-11", "411"),
        C3053("C3053.png", "特記4-12", "412"),
        C3054("C3054.png", "特記4-13", "413"),
        C3055("C3055.png", "特記4-14", "414"),
        C3056("C3056.png", "特記4-15", "415"),
        C3057("C3057.png", "特記5-1", "501"),
        C3058("C3058.png", "特記5-2", "502"),
        C3059("C3059.png", "特記5-3", "503"),
        C3060("C3060.png", "特記5-4", "504"),
        C3061("C3061.png", "特記5-5", "505"),
        C3062("C3062.png", "特記5-6", "506"),
        C3063("C3063.png", "特記6-1", "601"),
        C3064("C3064.png", "特記6-2", "602"),
        C3065("C3065.png", "特記6-3", "603"),
        C3066("C3066.png", "特記6-4", "604"),
        C3067("C3067.png", "特記6-5", "605"),
        C3068("C3068.png", "特記6-6", "606"),
        C3069("C3069.png", "特記6-7", "607"),
        C3070("C3070.png", "特記6-8", "608"),
        C3071("C3071.png", "特記6-9", "609"),
        C3072("C3072.png", "特記6-10", "610"),
        C3073("C3073.png", "特記6-11", "611"),
        C3074("C3074.png", "特記6-12", "612"),
        C3075("C3075.png", "特記7-1", "701"),
        C3076("C3076.png", "特記7-2", "702"),
        C4101("C4101.png", "特記資料1", "T001"),
        C4102("C4102.png", "特記資料2", "T002"),
        C4103("C4103.png", "特記資料3", "T003"),
        C4104("C4104.png", "特記資料4", "T004"),
        C4105("C4105.png", "特記資料5", "T005"),
        C4106("C4106.png", "特記資料6", "T006"),
        E0001("E0001.png", "主治医意見書：表", ""),
        E0002("E0002.png", "主治医意見書：裏", ""),
        D1005("D1005.png", "傷病特別疾病の経過及び投薬内容を含む治療内容", ""),
        D1008("D1008.png", "専門医受診の有無", ""),
        D1026("D1026.png", "意見書特記", ""),
        D1027("D1027.png", "症状としての安定性_不安定", ""),
        F1401A("F1401A.png", "その他資料1", ""),
        F1401B("F1401B.png", "その他資料2", ""),
        F1401C("F1401C.png", "その他資料3", ""),
        F1401D("F1401D.png", "その他資料4", ""),
        F1401E("F1401E.png", "その他資料5", ""),
        F1401F("F1401F.png", "その他資料6", ""),
        対象なし("", "", "");

        private final RString イメージ名;
        private final RString イメージ日本語名称;
        private final RString 特記事項番号;
        private static final RString 特記事項イメージ名称頭文字 = new RString("C30");
        private static final RString その他資料イメージ名称頭文字 = new RString("F1401");
        private static final int ファイル名開始位置 = 0;
        private static final int 連番有ファイル名文字数 = 12;
        private static final int 特記事項頭文字数 = 3;
        private static final int その他資料頭文字数 = 5;
        private static final int 特記事項帳票名文字数 = 5;
        private static final int その他資料帳票名文字数 = 6;
        private static final int 拡張子開始位置 = 8;

        private マスク有りイメージ一覧(String imageName, String 日本語名称, String 特記事項番号) {
            this.イメージ名 = new RString(imageName);
            this.イメージ日本語名称 = new RString(日本語名称);
            this.特記事項番号 = new RString(特記事項番号);
        }

        public RString getイメージ名() {
            return イメージ名;
        }

        public RString getイメージ日本語名称() {
            return イメージ日本語名称;
        }

        public RString get特記事項番号() {
            return 特記事項番号;
        }

        public static マスク有りイメージ一覧 getEnumToImageName(RString imageName) {
            if (imageName.length() == 連番有ファイル名文字数) {
                if (特記事項イメージ名称頭文字.equals(imageName.substring(ファイル名開始位置, 特記事項頭文字数))) {
                    imageName = imageName.substring(ファイル名開始位置, 特記事項帳票名文字数).concat(imageName.substring(拡張子開始位置, 連番有ファイル名文字数));
                } else if (その他資料イメージ名称頭文字.equals(imageName.substring(0, その他資料頭文字数))) {
                    imageName = imageName.substring(ファイル名開始位置, その他資料帳票名文字数).concat(imageName.substring(拡張子開始位置, 連番有ファイル名文字数));
                }
            }
            for (マスク有りイメージ一覧 image : マスク有りイメージ一覧.values()) {
                if (image.イメージ名.equals(imageName)) {
                    return image;
                }
            }
            return 対象なし;
        }

        public static マスク有りイメージ一覧 getEnumToName(RString name) {
            for (マスク有りイメージ一覧 image : マスク有りイメージ一覧.values()) {
                if (image.イメージ日本語名称.equals(name)) {
                    return image;
                }
            }
            return 対象なし;
        }

    }
}
