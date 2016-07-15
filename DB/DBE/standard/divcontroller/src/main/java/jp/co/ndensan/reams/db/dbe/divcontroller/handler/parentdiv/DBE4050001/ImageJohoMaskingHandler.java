/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4050001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.imagejohomasking.ImageJohoMaskingResult;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.ImageJohoMaskingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.dgImageMaskShoriTaishosha_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * イメージ情報マスキングの抽象Handlerクラスです。
 *
 * @reamsid_L DBE-1620-010 chengsanyuan
 */
public class ImageJohoMaskingHandler {

    private final ImageJohoMaskingDiv div;

    /**
     * コンストラクタです。
     *
     * @param div イメージ情報マスキングDiv
     */
    public ImageJohoMaskingHandler(ImageJohoMaskingDiv div) {
        this.div = div;
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
            try {
                row.setマスク区分(GenponMaskKubun.toValue(result.getマスク区分()).get名称());
            } catch (IllegalArgumentException e) {
                row.setマスク区分(RString.EMPTY);
            }
            row.get意見書受領日().setValue(result.get主治医意見書受領年月日());
            row.get調査票受領日().setValue(result.get認定調査受領年月日());
            row.set申請書管理番号(result.get申請書管理番号().value());
            row.set認定調査依頼履歴番号(new RString(result.get認定調査依頼履歴番号()));
            row.set主治医意見書作成依頼履歴番号(new RString(result.get主治医意見書作成依頼履歴番号()));
            row.set認定調査特記事項番号(result.get認定調査特記事項番号());
            row.set認定調査特記事項連番(new RString(result.get認定調査特記事項連番()));
            if (result.get帳票ID() == null) {
                row.set帳票ID(RString.EMPTY);
            } else {
                row.set帳票ID(result.get帳票ID().value());
            }
            row.set取込みページ番号(new RString(result.get取込みページ番号()));
            row.set共有ファイルID(new RString(result.getイメージ共有ファイルID().toString()));
            row.setイメージ区分(result.getイメージ区分());
            row.set認定申請年(new RString(result.get認定申請年()));
            row.set特記事項(result.get特記事項());
            setアクセスログ(result.get申請書管理番号().value());
            rowList.add(row);
        }
        div.getDgImageMaskShoriTaishosha().setDataSource(rowList);
    }

    /**
     * 検索条件入力値をクリアする
     */
    public void clear() {
        div.getDdlKensakuTaisho().setSelectedIndex(0);
        div.getTxtSearchStYMD().clearValue();
        div.getTxtSearchEdYMD().clearValue();
    }

    /**
     * イメージ情報パネルの設定
     */
    public void setMeisai() {
        dgImageMaskShoriTaishosha_Row row = div.getDgImageMaskShoriTaishosha().getClickedItem();
        div.getCcdNinteiShinseishaKihonInfo().initialize(new ShinseishoKanriNo(row.get申請書管理番号()));
        div.getRdoIkenshoHyo().setSelectedIndex(0);
        div.getRdoIkenshoUra().setDisabled(true);
        List<KeyValueDataSource> list = new ArrayList<>();
        for (GenponMaskKubun kubun : GenponMaskKubun.values()) {
            list.add(new KeyValueDataSource(kubun.getコード(), kubun.get名称()));
        }
        div.getDdlMaskKubun().setDataSource(list);
        div.getDdlMaskKubun().setDisabled(true);
        // TODO UZI.ImageMaskingにて、フレームワークのバージョンアップ後、予定対応
//        div.getCcdImageMasking().initialize();
    }

    /**
     * その他を変更の場合、イメージ情報パネルの設定が表示する。
     */
    public void changeImageJoho() {
        if (div.getRdoIkenshoHyo().getSelectedKey().equals(new RString("0"))) {
            div.getRdoIkenshoUra().setDisabled(true);
            div.getDdlMaskKubun().setDisabled(true);
        } else {
            div.getRdoIkenshoUra().setDisabled(false);
            div.getDdlMaskKubun().setDisabled(false);
        }
    }

    private void setアクセスログ(RString 申請書管理番号) {
        AccessLogger.log(AccessLogType.照会, PersonalData.of(ShikibetsuCode.EMPTY,
                new ExpandedInformation(new Code("0001"),
                        new RString("申請書管理番号"), 申請書管理番号)));
    }
}
