/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4050001;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.imagejohomasking.ImageJohoMaskingResult;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.business.core.textmasking.TextMaskingModel;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imagejohomasking.ImageJohoMaskingParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imagejohomasking.TextMaskingParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.ImageJohoMaskingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.dgImageMaskShoriTaishosha_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.dgImageMaskingTaisho_Row;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imagejohomasking.MaskingGaikyoChosaTokkiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imagejohomasking.MaskingKihonChosaTokkiEntity;
import jp.co.ndensan.reams.db.dbe.service.core.imagejohomasking.ImageJohoMaskingFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoChosaTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoChosaTokkiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IkenshoImageJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IkenshoImageJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.db.dbz.service.core.basic.GaikyoChosaTokkiManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.IkenshoImageJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedAppendOption;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

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
    private static final int 特記事項連番開始位置 = 6;
    private static final int 特記事項連番終了位置 = 4;
    private static final int 意見書_表ページ = 1;
    private static final int 意見書_裏ページ = 2;
    private static final RString 前排他用文字列 = new RString("DBEShinseishoKanriNo");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString マスク有 = new RString("有");
    private static final RString イメージファイル終端 = new RString(".png");
    private static final RString BAKファイル終端 = new RString("_BAK.png");
    private static final RString 編集後ファイル終端 = new RString("_NEW.png");
    private static final RString テキスト = new RString("1");
    private static final RString イメージ = new RString("2");
    private static final RString FLAG_TRUE = new RString("1");
    private static final RString FLAG_FALSE = new RString("0");
    private static final Comparator<dgImageMaskingTaisho_Row> 表示順
            = new Comparator<dgImageMaskingTaisho_Row>() {
                @Override
                public int compare(dgImageMaskingTaisho_Row o1, dgImageMaskingTaisho_Row o2) {
                    int 比較用１ = Integer.parseInt(o1.getSortNo().toString());
                    int 比較用２ = Integer.parseInt(o2.getSortNo().toString());
                    int 特記連番１ = Integer.parseInt(o1.getTokkijikoRenban().toString());
                    int 特記連番２ = Integer.parseInt(o2.getTokkijikoRenban().toString());
                    return 比較用１ == 比較用２ ? 特記連番１ - 特記連番２ : 比較用１ - 比較用２;
                }
            };

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
    public void initialize() {
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTxtMaxDisp().setValue(new Decimal(最大表示件数.toString()));
        div.getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
    }

    /**
     * 設定したパラメーターを用いて対象者のリストを作成します
     *
     * @return マスキング対象者のリスト
     */
    public List<ImageJohoMaskingResult> get対象者for画面() {
        FlexibleDate fromYMD;
        FlexibleDate toYMD;
        if (div.getTxtSearchYMD().getFromValue() != null) {
            fromYMD = new FlexibleDate(div.getTxtSearchYMD().getFromValue().toString());
        } else {
            fromYMD = FlexibleDate.EMPTY;
        }
        if (div.getTxtSearchYMD().getToValue() != null) {
            toYMD = new FlexibleDate(div.getTxtSearchYMD().getToValue().toString());
        } else {
            toYMD = FlexibleDate.EMPTY;
        }
        RString マスキングタイミング = DbBusinessConfig.get(ConfigNameDBE.マスキングチェックタイミング, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        ImageJohoMaskingParameter param = ImageJohoMaskingParameter.createImageJohoMaskingParameter(
                div.getCcdHokensya().getSelectedItem().get市町村コード(),
                fromYMD,
                toYMD,
                div.getDdlKensakuTaisho().getSelectedKey(),
                null,
                div.getTxtHihokenshaNumber().getValue(),
                div.getTxtShinsakaiKaisaiNo().getText(),
                div.getTxtMaxDisp().getValue(),
                new RString("1").equals(マスキングタイミング),
                !div.getChkMasking().getSelectedKeys().isEmpty());
        return ImageJohoMaskingFinder.createInstance().getDataForLoad(param).records();
    }

    /**
     * 設定したパラメーターを用いて対象者のリストを作成します
     *
     * @param shinseishoKanriNoList 申請書管理番号のリスト
     * @return マスキング対象者のリスト
     */
    public List<ImageJohoMaskingResult> get対象者forリスト(ShinseishoKanriNoList shinseishoKanriNoList) {
        RString マスキングタイミング = DbBusinessConfig.get(ConfigNameDBE.マスキングチェックタイミング, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        ImageJohoMaskingParameter param = ImageJohoMaskingParameter.createImageJohoMaskingParameter(
                LasdecCode.EMPTY,
                FlexibleDate.MAX,
                FlexibleDate.MAX,
                RString.EMPTY,
                shinseishoKanriNoList.getShinseishoKanriNoS(),
                RString.EMPTY,
                RString.EMPTY,
                div.getTxtMaxDisp().getValue(),
                new RString("1").equals(マスキングタイミング),
                false);
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
            row.set保険者名称(result.get市町村名称());
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
            if (result.isマスキング完了済()) {
                row.setマスキング完了済(new RString("○"));
            } else {
                row.setマスキング完了済(RString.EMPTY);
            }
            rowList.add(row);
        }
        div.getDgImageMaskShoriTaishosha().setDataSource(rowList);
    }

    /**
     * 検索条件入力値をクリアする
     */
    public void clear() {
        div.getTxtHihokenshaNumber().clearValue();
        div.getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
        div.getDdlKensakuTaisho().setSelectedIndex(0);
        div.getTxtSearchYMD().clearFromValue();
        div.getTxtSearchYMD().clearToValue();
        div.getTxtShinsakaiKaisaiNo().clearValue();
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTxtMaxDisp().setValue(new Decimal(最大表示件数.toString()));
        div.getChkMasking().setSelectedItemsByKey(new ArrayList<RString>());
    }

    /**
     * 検索条件入力値をクリアする
     */
    public void clearAndDisableSearchYMD() {
        div.getTxtSearchYMD().clearFromValue();
        div.getTxtSearchYMD().clearToValue();
        div.getTxtSearchYMD().setDisabled(true);
    }

    /**
     * イメージ情報パネルの設定
     */
    public void setMeisai() {
        DbAccessLogger accessLog = new DbAccessLogger();
        dgImageMaskShoriTaishosha_Row taishoshaRow = div.getDgImageMaskShoriTaishosha().getClickedItem();
        RString outputImagePath = Directory.createTmpDirectory();
        RString imagePath = RString.EMPTY;

        div.getCcdNinteiShinseishaKihonInfo().initialize(new ShinseishoKanriNo(taishoshaRow.get申請書管理番号()));
        RString ファイル名 = taishoshaRow.get保険者().concat(taishoshaRow.get被保番号());
        RDateTime 共有ファイルID = RDateTime.parse(taishoshaRow.get共有ファイルID().toString());

        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, taishoshaRow.get保険者());
        ViewStateHolder.put(ViewStateKeys.被保険者番号, taishoshaRow.get被保番号());
        ViewStateHolder.put(ViewStateKeys.共有ファイル名, ファイル名);
        ViewStateHolder.put(ViewStateKeys.イメージ共有ファイルID, 共有ファイルID);
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, taishoshaRow.get申請書管理番号());
        ViewStateHolder.put(ViewStateKeys.認定調査依頼履歴番号, taishoshaRow.get認定調査依頼履歴番号());
        ViewStateHolder.put(ViewStateKeys.主治医意見書作成依頼履歴番号, taishoshaRow.get主治医意見書作成依頼履歴番号());
        ViewStateHolder.put(ViewStateKeys.帳票分類ID, taishoshaRow.get帳票ID());
        ViewStateHolder.put(ViewStateKeys.保存フラグ, !taishoshaRow.getマスキング完了済().isEmpty());

        ReadOnlySharedFileEntryDescriptor descriptor = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(ファイル名), 共有ファイルID);
        try {
            imagePath = new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(outputImagePath)).getCanonicalPath());
            ViewStateHolder.put(ViewStateKeys.イメージ情報, imagePath);
        } catch (Exception ex) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        }

        前排他ロックキー(前排他用文字列.concat(taishoshaRow.get申請書管理番号()));

        ShoKisaiHokenshaNo shoKisaiHokenshaNo = new ShoKisaiHokenshaNo(taishoshaRow.get保険者());
        ExpandedInformation expandedInformation = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), taishoshaRow.get申請書管理番号());
        accessLog.store(shoKisaiHokenshaNo, taishoshaRow.get被保番号(), expandedInformation);

        File file = new File(imagePath.toString());
        List<dgImageMaskingTaisho_Row> rowList = new ArrayList<>();
        if (file.exists()) {
            setMaskingTaisho(file, rowList);
        }
        setTxetMaskingTaisho(rowList);
        setTextGaikyo(rowList);
        Collections.sort(rowList, 表示順);
        div.getDgImageMaskingTaisho().setDataSource(rowList);
        accessLog.flushBy(AccessLogType.照会);
    }

    private List<dgImageMaskingTaisho_Row> setMaskingTaisho(File file, List<dgImageMaskingTaisho_Row> rowList) {
        String[] files = file.list();
        if (files.length == 0) {
            return rowList;
        }

        RString imagePath = ViewStateHolder.get(ViewStateKeys.イメージ情報, RString.class);
        for (String imageFile : files) {
            dgImageMaskingTaisho_Row row = new dgImageMaskingTaisho_Row();
            row.setImageName(new RString(imageFile));
            row.setImagePath(Path.combinePath(imagePath, new RString(imageFile)));
            row.setTextImageKubun(イメージ);
            row.setGaikyoFlag(FLAG_FALSE);
            rowList.add(row);
        }

        for (int i = 0; i < rowList.size(); i++) {
            dgImageMaskingTaisho_Row 検索対象 = rowList.get(i);
            for (int j = 0; j < rowList.size(); j++) {
                dgImageMaskingTaisho_Row 検索用 = rowList.get(j);
                RString 比較用ファイル名 = 検索対象.getImageName().replace(new RString(".png"), new RString("_BAK.png"));
                if (検索用.getImageName().equals(比較用ファイル名)) {
                    検索対象.setHasMask(マスク有);
                    検索対象.setMaskImagePath(検索対象.getImagePath());
                    検索対象.setImagePath(検索用.getImagePath());
                    検索用.setState(状態_削除);
                }
            }
        }

        for (int i = 0; i < rowList.size(); i++) {
            dgImageMaskingTaisho_Row 検索対象 = rowList.get(i);
            if (!検索対象.getState().equals(状態_削除)) {
                マスク有りイメージ一覧 イメージ情報 = マスク有りイメージ一覧.getEnumToImageName(検索対象.getImageName());
                if (イメージ情報.getイメージ日本語名称().isEmpty()) {
                    検索対象.setState(状態_削除);
                } else {
                    RString 特記事項連番 = get特記事項連番(イメージ情報, 検索対象);
                    if (new RString("0").equals(特記事項連番)) {
                        検索対象.setImageName(イメージ情報.getイメージ日本語名称());
                    } else {
                        検索対象.setImageName(イメージ情報.getイメージ日本語名称().concat(new RString("_")).concat(特記事項連番));
                    }
                    検索対象.setTokkijikoRenban(特記事項連番);
                    検索対象.setSortNo(new RString(イメージ情報.get番号()));
                }
            }
        }

        for (int i = rowList.size() - 1; i >= 0; i--) {
            dgImageMaskingTaisho_Row 検索対象 = rowList.get(i);
            if (検索対象.getState().equals(状態_削除)) {
                rowList.remove(i);
            }
        }
        return rowList;
    }

    private RString get特記事項連番(マスク有りイメージ一覧 イメージ情報, dgImageMaskingTaisho_Row 検索対象) {
        if (new RString("特記").equals(イメージ情報.getイメージ日本語名称().substring(0, 2))) {
            int 連番;
            if (検索対象.getMaskImagePath().isEmpty()) {
                連番 = Integer.parseInt(検索対象.getImagePath().substring(
                        検索対象.getImagePath().length() - 特記事項連番開始位置, 検索対象.getImagePath().length() - 特記事項連番終了位置).toString()) + 1;
            } else {
                連番 = Integer.parseInt(検索対象.getMaskImagePath().substring(
                        検索対象.getMaskImagePath().length() - 特記事項連番開始位置, 検索対象.getMaskImagePath().length() - 特記事項連番終了位置).toString()) + 1;
            }
            return new RString(連番);
        } else {
            return new RString("0");
        }
    }

    private List<dgImageMaskingTaisho_Row> setTxetMaskingTaisho(List<dgImageMaskingTaisho_Row> rowList) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        RString 認定調査依頼履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査依頼履歴番号, RString.class);
        TextMaskingParameter param = TextMaskingParameter.createTextMaskingParameter(申請書管理番号, 認定調査依頼履歴番号);
        List<MaskingKihonChosaTokkiEntity> tokkiList = ImageJohoMaskingFinder.createInstance().getNinteiChosaTokkijiko(param);

        if (tokkiList.isEmpty()) {
            return rowList;
        }

        for (MaskingKihonChosaTokkiEntity item : tokkiList) {
            dgImageMaskingTaisho_Row row = new dgImageMaskingTaisho_Row();
            マスク有りイメージ一覧 tokki = マスク有りイメージ一覧.getEnumToTokkiNo(item.get認定調査特記事項番号());
            row.setTextImageKubun(テキスト);
            row.setImageName(tokki.getイメージ日本語名称().concat(new RString("_")).concat(new RString(item.get認定調査特記事項連番())));
            row.setImagePath(item.get特記事項原本());
            row.setGaikyoFlag(FLAG_FALSE);
            row.setSortNo(new RString(tokki.get番号()));
            row.setTokkijikoRenban(new RString(item.get認定調査特記事項連番()));
            if (item.get特記事項マスク() != null && !item.get特記事項マスク().isEmpty()) {
                row.setMaskImagePath(item.get特記事項マスク());
                row.setHasMask(マスク有);
            } else {
                row.setMaskImagePath(RString.EMPTY);
                row.setHasMask(RString.EMPTY);
            }
            rowList.add(row);
        }
        return rowList;
    }

    private List<dgImageMaskingTaisho_Row> setTextGaikyo(List<dgImageMaskingTaisho_Row> rowList) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        RString 認定調査依頼履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査依頼履歴番号, RString.class);
        TextMaskingParameter param = TextMaskingParameter.createTextMaskingParameter(申請書管理番号, 認定調査依頼履歴番号);
        List<MaskingGaikyoChosaTokkiEntity> gaikyoTokkiList = ImageJohoMaskingFinder.createInstance().getGaikyoChosaTokkijiko(param);

        if (gaikyoTokkiList.isEmpty()) {
            return rowList;
        }

        for (MaskingGaikyoChosaTokkiEntity gaikyoTokki : gaikyoTokkiList) {
            dgImageMaskingTaisho_Row row = new dgImageMaskingTaisho_Row();
            マスク有りイメージ一覧 tokki = マスク有りイメージ一覧.C0007;
            row.setTextImageKubun(テキスト);
            row.setImageName(tokki.イメージ日本語名称);
            row.setImagePath(gaikyoTokki.get概況調査特記事項原本());
            row.setGaikyoFlag(FLAG_TRUE);
            row.setSortNo(new RString(tokki.get番号()));
            row.setTokkijikoRenban(new RString("0"));
            if (gaikyoTokki.get概況調査特記事項マスク() != null && !gaikyoTokki.get概況調査特記事項マスク().isEmpty()) {
                row.setMaskImagePath(gaikyoTokki.get概況調査特記事項マスク());
                row.setHasMask(マスク有);
            } else {
                row.setMaskImagePath(RString.EMPTY);
                row.setHasMask(RString.EMPTY);
            }
            rowList.add(row);
        }
        return rowList;
    }

    /**
     * 今回編集したマスキングデータを削除いたします
     */
    public void deleteEditedData() {
        dgImageMaskingTaisho_Row row = ViewStateHolder.get(ViewStateKeys.詳細データ, dgImageMaskingTaisho_Row.class);
        if (row.getState().equals(状態_追加) || row.getState().equals(状態_修正)) {
            if (イメージ.equals(row.getTextImageKubun())) {
                new File(row.getEditImagePath().toString()).delete();
            }
            row.setEditImagePath(RString.EMPTY);
        }
        if (!row.getMaskImagePath().isEmpty()) {
            row.setHasMask(マスク有);
        }
        row.setState(RString.EMPTY);
        div.getDgImageMaskingTaisho().getDataSource().set(row.getId(), row);
        ViewStateHolder.put(ViewStateKeys.詳細データ, row);
    }

    /**
     * 既に保存されているマスキングデータを削除いたします
     */
    public void deleteMaskingData() {
        dgImageMaskingTaisho_Row row = ViewStateHolder.get(ViewStateKeys.詳細データ, dgImageMaskingTaisho_Row.class);
        row.setState(状態_削除);
        row.setHasMask(RString.EMPTY);
        div.getDgImageMaskingTaisho().getDataSource().set(row.getId(), row);
        ViewStateHolder.put(ViewStateKeys.詳細データ, row);
    }

    /**
     * マスキングデータ保存時にデータグリッドを更新します
     *
     * @param newImagePath 編集したマスキングデータのパス
     */
    public void updateRow(RString newImagePath) {
        dgImageMaskingTaisho_Row row = ViewStateHolder.get(ViewStateKeys.詳細データ, dgImageMaskingTaisho_Row.class);
        row.setEditImagePath(newImagePath);
        if (row.getMaskImagePath().isEmpty()) {
            row.setState(状態_追加);
        } else {
            row.setState(状態_修正);
        }
        div.getDgImageMaskingTaisho().getDataSource().set(row.getId(), row);
        ViewStateHolder.put(ViewStateKeys.詳細データ, row);
    }

    /**
     * マスキングデータの保存を行います
     */
    public void update() {
        DbAccessLogger accessLog = new DbAccessLogger();
        imageJohoManager = IkenshoImageJohoManager.createInstance();
        tokkijikoManager = NinteichosahyoTokkijikoManager.createInstance();
        gaikyoManager = GaikyoChosaTokkiManager.createInstance();
        for (dgImageMaskingTaisho_Row row : div.getDgImageMaskingTaisho().getDataSource()) {
            if (!RString.isNullOrEmpty(row.getState())) {
                if (イメージ.equals(row.getTextImageKubun())) {
                    saveLocalFile(row);
                    saveGamenData(row);
                    saveSharedFile(row);
                } else {
                    saveGamenDataText(row);
                }
            }
        }
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        RString 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, RString.class);
        RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
        ShoKisaiHokenshaNo shoKisaiHokenshaNo = new ShoKisaiHokenshaNo(証記載保険者番号);
        ExpandedInformation expandedInformation = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        accessLog.store(shoKisaiHokenshaNo, 被保険者番号, expandedInformation);
        accessLog.flushBy(AccessLogType.更新);
        前排他キーの解除(前排他用文字列.concat(申請書管理番号));
    }

    private void saveSharedFile(dgImageMaskingTaisho_Row row) {
        RString ファイル名 = ViewStateHolder.get(ViewStateKeys.共有ファイル名, RString.class);
        RDateTime 共有ファイルID = ViewStateHolder.get(ViewStateKeys.イメージ共有ファイルID, RDateTime.class);
        ReadOnlySharedFileEntryDescriptor descriptor = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(ファイル名), 共有ファイルID);
        SharedAppendOption option = new SharedAppendOption();
        option.overWrite(true);
        SharedFile.appendNewFile(descriptor, new FilesystemPath(row.getImagePath()), "", option);
        if (row.getState().equals(状態_追加) || row.getState().equals(状態_修正)) {
            SharedFile.appendNewFile(descriptor, new FilesystemPath(row.getEditImagePath()), "", option);
        } else if (row.getState().equals(状態_削除)) {
            SharedFile.deleteFileInEntry(descriptor, row.getMaskImagePath().toString());
        }
    }

    private void saveLocalFile(dgImageMaskingTaisho_Row row) {
        if (row.getState().equals(状態_削除)) {
            File maskFile = new File(row.getMaskImagePath().toString());
            File genponFile = new File(row.getImagePath().toString());
            row.setMaskImagePath(new RString(genponFile.getName()));
            maskFile.delete();
            genponFile.renameTo(maskFile);
            row.setImagePath(new RString(maskFile.getPath()));
        } else {
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
    }

    private void saveGamenData(dgImageMaskingTaisho_Row row) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        int 認定調査依頼履歴番号 = Integer.parseInt(ViewStateHolder.get(ViewStateKeys.認定調査依頼履歴番号, RString.class).toString());
        if (row.getState().equals(状態_追加)) {
            if (row.getImageName().equals(マスク有りイメージ一覧.C0007.getイメージ日本語名称())) {
                GaikyoChosaTokki gaikyotokki = new GaikyoChosaTokki(申請書管理番号,
                        認定調査依頼履歴番号,
                        TokkijikoTextImageKubun.イメージ.getコード());

                GaikyoChosaTokkiBuilder builder = gaikyotokki.createBuilderForEdit();

                builder.set特記(RString.EMPTY);

                gaikyoManager.save概況調査特記(builder.build());
            } else if (row.getImageName().equals(マスク有りイメージ一覧.E0001.getイメージ日本語名称())
                    || row.getImageName().equals(マスク有りイメージ一覧.E0002.getイメージ日本語名称())) {

                int 主治医意見書作成依頼履歴番号 = Integer.parseInt(ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼履歴番号, RString.class).toString());
                RString 帳票ID = ViewStateHolder.get(ViewStateKeys.帳票分類ID, RString.class);
                Code 帳票分類ID;
                if (帳票ID.equals(new RString("701")) || 帳票ID.equals(new RString("702"))) {
                    帳票分類ID = row.getImageName().equals(マスク有りイメージ一覧.E0001.getイメージ日本語名称()) ? new Code("701") : new Code("702");
                } else if (帳票ID.equals(new RString("121")) || 帳票ID.equals(new RString("122"))) {
                    帳票分類ID = row.getImageName().equals(マスク有りイメージ一覧.E0001.getイメージ日本語名称()) ? new Code("121") : new Code("122");
                } else if (帳票ID.equals(new RString("777")) || 帳票ID.equals(new RString("778"))) {
                    帳票分類ID = row.getImageName().equals(マスク有りイメージ一覧.E0001.getイメージ日本語名称()) ? new Code("777") : new Code("778");
                } else if (帳票ID.equals(new RString("999"))) {
                    帳票分類ID = new Code("999");
                } else {
                    帳票分類ID = new Code(帳票ID);
                }

                IkenshoImageJoho imageJoho = new IkenshoImageJoho(
                        申請書管理番号,
                        主治医意見書作成依頼履歴番号,
                        帳票分類ID, GenponMaskKubun.マスク.getコード(),
                        1);

                IkenshoImageJohoBuilder builder = imageJoho.createBuilderForEdit();

                imageJohoManager.save要介護認定意見書イメージ情報(builder.build());

            } else if (new RString("特記").equals(row.getImageName().substring(0, 2))) {
                int 連番 = Integer.parseInt(row.getEditImagePath().substring(row.getEditImagePath().length() - 特記事項連番開始位置, row.getEditImagePath().length() - 特記事項連番終了位置).toString()) + 1;
                NinteichosahyoTokkijiko tokkijiko = new NinteichosahyoTokkijiko(
                        申請書管理番号,
                        認定調査依頼履歴番号,
                        マスク有りイメージ一覧.getEnumToName(row.getImageName().substring(0, 6)).get特記事項番号(),
                        連番,
                        TokkijikoTextImageKubun.イメージ.getコード(),
                        new Code(GenponMaskKubun.マスク.getコード()));

                NinteichosahyoTokkijikoBuilder builder = tokkijiko.createBuilderForEdit();

                builder.set特記事項(RString.EMPTY);

                tokkijikoManager.save認定調査票_特記情報(builder.build());
            }
        } else if (row.getState().equals(状態_削除)) {
            if (row.getImageName().equals(マスク有りイメージ一覧.C0007.getイメージ日本語名称())) {
                GaikyoChosaTokkiManager dbt5213Manager = InstanceProvider.create(GaikyoChosaTokkiManager.class);
                GaikyoChosaTokki gaikyotokki = dbt5213Manager.get概況調査特記マスク(
                        申請書管理番号,
                        認定調査依頼履歴番号,
                        TokkijikoTextImageKubun.イメージ.getコード());
                if (gaikyotokki != null) {
                    gaikyotokki = gaikyotokki.deleted();
                    gaikyoManager.save概況調査特記(gaikyotokki);
                }
            } else if (row.getImageName().equals(マスク有りイメージ一覧.E0001.getイメージ日本語名称())
                    || row.getImageName().equals(マスク有りイメージ一覧.E0002.getイメージ日本語名称())) {
                int 主治医意見書作成依頼履歴番号 = Integer.parseInt(ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼履歴番号, RString.class).toString());
                RString 帳票ID = ViewStateHolder.get(ViewStateKeys.帳票分類ID, RString.class);
                Code 帳票分類ID;
                if (帳票ID.equals(new RString("701")) || 帳票ID.equals(new RString("702"))) {
                    帳票分類ID = row.getImageName().equals(マスク有りイメージ一覧.E0001.getイメージ日本語名称()) ? new Code("701") : new Code("702");
                } else if (帳票ID.equals(new RString("121")) || 帳票ID.equals(new RString("122"))) {
                    帳票分類ID = row.getImageName().equals(マスク有りイメージ一覧.E0001.getイメージ日本語名称()) ? new Code("121") : new Code("122");
                } else if (帳票ID.equals(new RString("777")) || 帳票ID.equals(new RString("778"))) {
                    帳票分類ID = row.getImageName().equals(マスク有りイメージ一覧.E0001.getイメージ日本語名称()) ? new Code("777") : new Code("778");
                } else if (帳票ID.equals(new RString("999"))) {
                    帳票分類ID = new Code("999");
                } else {
                    帳票分類ID = new Code(帳票ID);
                }
                IkenshoImageJohoManager dbt5305 = IkenshoImageJohoManager.createInstance();
                IkenshoImageJoho imageJoho = dbt5305.get要介護認定意見書イメージ情報(
                        申請書管理番号,
                        主治医意見書作成依頼履歴番号,
                        帳票分類ID,
                        GenponMaskKubun.マスク.getコード(),
                        1);
                if (imageJoho != null) {
                    imageJoho = imageJoho.deleted();
                    imageJohoManager.save要介護認定意見書イメージ情報(imageJoho);
                }
            } else if (new RString("特記").equals(row.getImageName().substring(0, 2))) {
                int 連番 = Integer.parseInt(row.getImagePath().substring(row.getImagePath().length() - 特記事項連番開始位置, row.getImagePath().length() - 特記事項連番終了位置).toString()) + 1;
                NinteichosahyoTokkijikoManager dbt5205 = NinteichosahyoTokkijikoManager.createInstance();
                NinteichosahyoTokkijiko tokkijiko = dbt5205.get認定調査票_特記情報(
                        申請書管理番号,
                        認定調査依頼履歴番号,
                        マスク有りイメージ一覧.getEnumToName(row.getImageName().substring(0, 6)).get特記事項番号(),
                        連番,
                        TokkijikoTextImageKubun.イメージ.getコード(),
                        new Code(GenponMaskKubun.マスク.getコード()));
                if (tokkijiko != null) {
                    tokkijiko = tokkijiko.deleted();
                    tokkijikoManager.save認定調査票_特記情報(tokkijiko);
                }
            }
        }
    }

    private void saveGamenDataText(dgImageMaskingTaisho_Row row) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        int 認定調査依頼履歴番号 = Integer.parseInt(ViewStateHolder.get(ViewStateKeys.認定調査依頼履歴番号, RString.class).toString());
        if (row.getState().equals(状態_追加)) {
            if (row.getImageName().equals(マスク有りイメージ一覧.C0007.getイメージ日本語名称())) {
                GaikyoChosaTokki gaikyotokki = new GaikyoChosaTokki(申請書管理番号,
                        認定調査依頼履歴番号,
                        TokkijikoTextImageKubun.テキスト.getコード());

                GaikyoChosaTokkiBuilder builder = gaikyotokki.createBuilderForEdit();

                builder.set特記(row.getEditImagePath());

                gaikyoManager.save概況調査特記(builder.build());
            } else if (new RString("特記").equals(row.getImageName().substring(0, 2))) {
                NinteichosahyoTokkijiko tokkijiko = new NinteichosahyoTokkijiko(
                        申請書管理番号,
                        認定調査依頼履歴番号,
                        マスク有りイメージ一覧.getEnumToName(row.getImageName().substring(0, 6)).get特記事項番号(),
                        Integer.parseInt(row.getTokkijikoRenban().toString()),
                        TokkijikoTextImageKubun.テキスト.getコード(),
                        new Code(GenponMaskKubun.マスク.getコード()));

                NinteichosahyoTokkijikoBuilder builder = tokkijiko.createBuilderForEdit();

                builder.set特記事項(row.getEditImagePath());

                tokkijikoManager.save認定調査票_特記情報(builder.build());
            }
        } else if (row.getState().equals(状態_削除)) {
            if (row.getImageName().equals(マスク有りイメージ一覧.C0007.getイメージ日本語名称())) {
                GaikyoChosaTokkiManager dbt5213Manager = InstanceProvider.create(GaikyoChosaTokkiManager.class);
                GaikyoChosaTokki gaikyotokki = dbt5213Manager.get概況調査特記マスク(
                        申請書管理番号,
                        認定調査依頼履歴番号,
                        TokkijikoTextImageKubun.テキスト.getコード());
                if (gaikyotokki != null) {
                    gaikyotokki = gaikyotokki.deleted();
                    gaikyoManager.save概況調査特記(gaikyotokki);
                }
            } else if (new RString("特記").equals(row.getImageName().substring(0, 2))) {
                NinteichosahyoTokkijikoManager dbt5205 = NinteichosahyoTokkijikoManager.createInstance();
                NinteichosahyoTokkijiko tokkijiko = dbt5205.get認定調査票_特記情報(
                        申請書管理番号,
                        認定調査依頼履歴番号,
                        マスク有りイメージ一覧.getEnumToName(row.getImageName().substring(0, 6)).get特記事項番号(),
                        Integer.parseInt(row.getTokkijikoRenban().toString()),
                        TokkijikoTextImageKubun.テキスト.getコード(),
                        new Code(GenponMaskKubun.マスク.getコード()));
                if (tokkijiko != null) {
                    tokkijiko = tokkijiko.deleted();
                    tokkijikoManager.save認定調査票_特記情報(tokkijiko);
                }
            }
        } else if (row.getState().equals(状態_修正)) {
            if (row.getImageName().equals(マスク有りイメージ一覧.C0007.getイメージ日本語名称())) {
                GaikyoChosaTokkiManager dbt5213Manager = InstanceProvider.create(GaikyoChosaTokkiManager.class);
                GaikyoChosaTokki gaikyotokki = dbt5213Manager.get概況調査特記マスク(
                        申請書管理番号,
                        認定調査依頼履歴番号,
                        TokkijikoTextImageKubun.テキスト.getコード());
                if (gaikyotokki != null) {
                    GaikyoChosaTokkiBuilder builder = gaikyotokki.createBuilderForEdit();
                    builder.set特記(row.getEditImagePath());
                    gaikyoManager.save概況調査特記(builder.build());
                }
            } else if (new RString("特記").equals(row.getImageName().substring(0, 2))) {
                NinteichosahyoTokkijikoManager dbt5205 = NinteichosahyoTokkijikoManager.createInstance();
                NinteichosahyoTokkijiko tokkijiko = dbt5205.get認定調査票_特記情報(
                        申請書管理番号,
                        認定調査依頼履歴番号,
                        マスク有りイメージ一覧.getEnumToName(row.getImageName().substring(0, 6)).get特記事項番号(),
                        Integer.parseInt(row.getTokkijikoRenban().toString()),
                        TokkijikoTextImageKubun.テキスト.getコード(),
                        new Code(GenponMaskKubun.マスク.getコード()));
                if (tokkijiko != null) {
                    NinteichosahyoTokkijikoBuilder builder = tokkijiko.createBuilderForEdit();
                    builder.set特記事項(row.getEditImagePath());
                    tokkijikoManager.save認定調査票_特記情報(builder.build());
                }
            }
        }
    }

    /**
     * 一覧画面に戻るときは前排他を解除します
     */
    public void releaseLock() {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        前排他キーの解除(前排他用文字列.concat(申請書管理番号));
    }

    /**
     * 選択された列に応じてボタンの制御を変更します
     */
    public void changeButtonState() {
        dgImageMaskingTaisho_Row row = ViewStateHolder.get(ViewStateKeys.詳細データ, dgImageMaskingTaisho_Row.class);
        if (イメージ.equals(row.getTextImageKubun())) {
            div.getBtnMaskingGenpon().setDisplayNone(false);
            div.getBtnMaskingMask().setDisplayNone(false);
            div.getBtnMaskingGenponText().setDisplayNone(true);
            div.getBtnMaskingMaskText().setDisplayNone(true);
            if (row.getHasMask().isEmpty() && !row.getState().equals(状態_追加) && !row.getState().equals(状態_修正)) {
                div.getBtnMaskingGenpon().setDisabled(false);
            } else {
                div.getBtnMaskingGenpon().setDisabled(true);
            }
            if (row.getHasMask().equals(マスク有) || row.getState().equals(状態_追加) || row.getState().equals(状態_修正)) {
                div.getBtnMaskingMask().setDisabled(false);
            } else {
                div.getBtnMaskingMask().setDisabled(true);
            }
        } else {
            div.getBtnMaskingGenpon().setDisplayNone(true);
            div.getBtnMaskingMask().setDisplayNone(true);
            div.getBtnMaskingGenponText().setDisplayNone(false);
            div.getBtnMaskingMaskText().setDisplayNone(false);
            if (row.getHasMask().isEmpty() && !row.getState().equals(状態_追加) && !row.getState().equals(状態_修正)) {
                div.getBtnMaskingGenponText().setDisabled(false);
            } else {
                div.getBtnMaskingGenponText().setDisabled(true);
            }
            if (row.getHasMask().equals(マスク有) || row.getState().equals(状態_追加) || row.getState().equals(状態_修正)) {
                div.getBtnMaskingMaskText().setDisabled(false);
            } else {
                div.getBtnMaskingMaskText().setDisabled(true);
            }
        }
        if (row.getHasMask().equals(マスク有) && row.getState().isEmpty()) {
            div.getBtnSakujo().setDisabled(false);
        } else {
            div.getBtnSakujo().setDisabled(true);
        }
        if (!row.getState().isEmpty()) {
            div.getBtnTorikeshi().setDisabled(false);
        } else {
            div.getBtnTorikeshi().setDisabled(true);
        }
    }

    public void setTextMaskingData(TextMaskingModel model, dgImageMaskingTaisho_Row row) {
        model.set編集タイトル(row.getImageName());
        model.set原本テキスト(row.getImagePath());
        if (new RString("0").equals(row.getTokkijikoRenban())) {
            model.set調査項目番号(RString.EMPTY);
        } else {
            model.set調査項目番号(マスク有りイメージ一覧.getEnumToName(row.getImageName().substring(0, 6)).get特記事項番号());
        }
        model.set特記連番(Integer.parseInt(row.getTokkijikoRenban().toString()));
    }

    public boolean hasChanged() {
        boolean hasChanged = false;
        for (dgImageMaskingTaisho_Row item : div.getDgImageMaskingTaisho().getDataSource()) {
            if (!item.getState().isEmpty()) {
                hasChanged = true;
                break;
            }
        }
        return hasChanged;
    }

    public void setDisabledStateToButton() {
        div.getBtnMaskingGenpon().setDisabled(true);
        div.getBtnMaskingMask().setDisabled(true);
        div.getBtnSakujo().setDisabled(true);
        div.getBtnTorikeshi().setDisabled(true);
    }

    public void getKekkaTorokuParam() {
        dgImageMaskShoriTaishosha_Row row = div.getDgImageMaskShoriTaishosha().getActiveRow();
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, new ShinseishoKanriNo(row.get申請書管理番号()));
        ViewStateHolder.put(ViewStateKeys.認定調査履歴番号, Integer.parseInt(row.get認定調査依頼履歴番号().toString()));
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, row.get保険者());
        ViewStateHolder.put(ViewStateKeys.被保険者番号, row.get被保番号());
    }

    private void 前排他ロックキー(RString 排他ロックキー) {
        LockingKey 前排他ロックキー = new LockingKey(排他ロックキー);
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            throw new PessimisticLockingException();
        }
    }

    private void 前排他キーの解除(RString 排他) {
        LockingKey 排他キー = new LockingKey(排他);
        RealInitialLocker.release(排他キー);
    }

    private enum マスク有りイメージ一覧 {

        C0007("C0007.png", "概況調査・特記事項", "", 3),
        C3001("C3001.png", "特記1-01", "101", 4),
        C3006("C3006.png", "特記1-02", "102", 5),
        C3010("C3010.png", "特記1-03", "103", 6),
        C3011("C3011.png", "特記1-04", "104", 7),
        C3012("C3012.png", "特記1-05", "105", 8),
        C3013("C3013.png", "特記1-06", "106", 9),
        C3014("C3014.png", "特記1-07", "107", 10),
        C3015("C3015.png", "特記1-08", "108", 11),
        C3016("C3016.png", "特記1-09", "109", 12),
        C3017("C3017.png", "特記1-10", "110", 13),
        C3018("C3018.png", "特記1-11", "111", 14),
        C3019("C3019.png", "特記1-12", "112", 15),
        C3020("C3020.png", "特記1-13", "113", 16),
        C3021("C3021.png", "特記2-01", "201", 17),
        C3022("C3022.png", "特記2-02", "202", 18),
        C3023("C3023.png", "特記2-03", "203", 19),
        C3024("C3024.png", "特記2-04", "204", 20),
        C3025("C3025.png", "特記2-05", "205", 21),
        C3026("C3026.png", "特記2-06", "206", 22),
        C3027("C3027.png", "特記2-07", "207", 23),
        C3028("C3028.png", "特記2-08", "208", 24),
        C3029("C3029.png", "特記2-09", "209", 25),
        C3030("C3030.png", "特記2-10", "210", 26),
        C3031("C3031.png", "特記2-11", "211", 27),
        C3032("C3032.png", "特記2-12", "212", 28),
        C3033("C3033.png", "特記3-01", "301", 29),
        C3034("C3034.png", "特記3-02", "302", 30),
        C3035("C3035.png", "特記3-03", "303", 31),
        C3036("C3036.png", "特記3-04", "304", 32),
        C3037("C3037.png", "特記3-05", "305", 33),
        C3038("C3038.png", "特記3-06", "306", 34),
        C3039("C3039.png", "特記3-07", "307", 35),
        C3040("C3040.png", "特記3-08", "308", 36),
        C3041("C3041.png", "特記3-09", "309", 37),
        C3042("C3042.png", "特記4-01", "401", 38),
        C3043("C3043.png", "特記4-02", "402", 39),
        C3044("C3044.png", "特記4-03", "403", 40),
        C3045("C3045.png", "特記4-04", "404", 41),
        C3046("C3046.png", "特記4-05", "405", 42),
        C3047("C3047.png", "特記4-06", "406", 43),
        C3048("C3048.png", "特記4-07", "407", 44),
        C3049("C3049.png", "特記4-08", "408", 45),
        C3050("C3050.png", "特記4-09", "409", 46),
        C3051("C3051.png", "特記4-10", "410", 47),
        C3052("C3052.png", "特記4-11", "411", 48),
        C3053("C3053.png", "特記4-12", "412", 49),
        C3054("C3054.png", "特記4-13", "413", 50),
        C3055("C3055.png", "特記4-14", "414", 51),
        C3056("C3056.png", "特記4-15", "415", 52),
        C3057("C3057.png", "特記5-01", "501", 53),
        C3058("C3058.png", "特記5-02", "502", 54),
        C3059("C3059.png", "特記5-03", "503", 55),
        C3060("C3060.png", "特記5-04", "504", 56),
        C3061("C3061.png", "特記5-05", "505", 57),
        C3062("C3062.png", "特記5-06", "506", 58),
        C3063("C3063.png", "特記6-01", "601", 59),
        C3064("C3064.png", "特記6-02", "602", 60),
        C3065("C3065.png", "特記6-03", "603", 61),
        C3066("C3066.png", "特記6-04", "604", 62),
        C3067("C3067.png", "特記6-05", "605", 63),
        C3068("C3068.png", "特記6-06", "606", 64),
        C3069("C3069.png", "特記6-07", "607", 65),
        C3070("C3070.png", "特記6-08", "608", 66),
        C3071("C3071.png", "特記6-09", "609", 67),
        C3072("C3072.png", "特記6-10", "610", 68),
        C3073("C3073.png", "特記6-11", "611", 69),
        C3074("C3074.png", "特記6-12", "612", 70),
        C3075("C3075.png", "特記7-01", "701", 71),
        C3076("C3076.png", "特記7-02", "702", 72),
        C4101("C4101.png", "特記資料1", "T001", 73),
        C4102("C4102.png", "特記資料2", "T002", 74),
        C4103("C4103.png", "特記資料3", "T003", 75),
        C4104("C4104.png", "特記資料4", "T004", 76),
        C4105("C4105.png", "特記資料5", "T005", 77),
        C4106("C4106.png", "特記資料6", "T006", 78),
        E0001("E0001.png", "主治医意見書：表", "", 1),
        E0002("E0002.png", "主治医意見書：裏", "", 2),
        D1005("D1005.png", "傷病特別疾病の経過及び投薬内容を含む治療内容", "", 79),
        D1008("D1008.png", "専門医受診の有無", "", 80),
        D1026("D1026.png", "意見書特記", "", 81),
        D1027("D1027.png", "症状としての安定性_不安定", "", 82),
        F1401A("F1401A.png", "その他資料1", "", 83),
        F1401B("F1401B.png", "その他資料2", "", 84),
        F1401C("F1401C.png", "その他資料3", "", 85),
        F1401D("F1401D.png", "その他資料4", "", 86),
        F1401E("F1401E.png", "その他資料5", "", 87),
        F1401F("F1401F.png", "その他資料6", "", 88),
        対象なし("", "", "", 0);

        private final RString イメージ名;
        private final RString イメージ日本語名称;
        private final RString 特記事項番号;
        private final int ソート用番号;
        private static final RString 特記事項イメージ名称頭文字 = new RString("C30");
        private static final RString その他資料イメージ名称頭文字 = new RString("F1401");
        private static final int ファイル名開始位置 = 0;
        private static final int 連番有ファイル名文字数 = 12;
        private static final int 特記事項頭文字数 = 3;
        private static final int その他資料頭文字数 = 5;
        private static final int 特記事項帳票名文字数 = 5;
        private static final int その他資料帳票名文字数 = 6;
        private static final int 拡張子開始位置 = 8;

        private マスク有りイメージ一覧(String imageName, String 日本語名称, String 特記事項番号, int ソート用番号) {
            this.イメージ名 = new RString(imageName);
            this.イメージ日本語名称 = new RString(日本語名称);
            this.特記事項番号 = new RString(特記事項番号);
            this.ソート用番号 = ソート用番号;
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

        public int get番号() {
            return ソート用番号;
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

        public static マスク有りイメージ一覧 getEnumToTokkiNo(RString tokkiNo) {
            for (マスク有りイメージ一覧 image : マスク有りイメージ一覧.values()) {
                if (image.特記事項番号.equals(tokkiNo)) {
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
