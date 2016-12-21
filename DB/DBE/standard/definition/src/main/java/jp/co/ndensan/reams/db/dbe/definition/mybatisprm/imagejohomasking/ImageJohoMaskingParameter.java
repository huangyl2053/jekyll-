/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imagejohomasking;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ情報マスキングのパラメータクラス
 *
 * @reamsid_L DBE-1620-010 chengsanyuan
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ImageJohoMaskingParameter {

    private final LasdecCode 市町村コード;
    private final FlexibleDate 日付範囲開始;
    private final FlexibleDate 日付範囲終了;
    private final RString 取下;
    private final RString 延期;
    private final RString イメージ区分;
    private final RString 事項番号;
    private final List<RString> 申請書管理番号リスト;

    private final boolean is用紙タイプ;
    private final boolean is画面;
    private final boolean isメニュー;
    private final boolean is保険者;
    private final boolean is審査会開催予定日;
    private final boolean is一次判定日;
    private final boolean is主治医意見書受領日;
    private final boolean is認定調査結果受領日;
    private final boolean is申請日;
    private final boolean is日付範囲開始;
    private final boolean is日付範囲終了;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     */
    private ImageJohoMaskingParameter(
            LasdecCode 市町村コード,
            FlexibleDate 日付範囲開始,
            FlexibleDate 日付範囲終了,
            RString 取下,
            RString 延期,
            RString イメージ区分,
            RString 事項番号,
            List<RString> 申請書管理番号リスト,
            boolean is用紙タイプ,
            boolean is画面,
            boolean isメニュー,
            boolean is保険者,
            boolean is審査会開催予定日,
            boolean is日付範囲開始,
            boolean is日付範囲終了,
            boolean is一次判定日,
            boolean is主治医意見書受領日,
            boolean is認定調査結果受領日,
            boolean is申請日) {
        this.日付範囲開始 = 日付範囲開始;
        this.市町村コード = 市町村コード;
        this.日付範囲終了 = 日付範囲終了;
        this.取下 = 取下;
        this.延期 = 延期;
        this.イメージ区分 = イメージ区分;
        this.事項番号 = 事項番号;
        this.申請書管理番号リスト = 申請書管理番号リスト;
        this.is用紙タイプ = is用紙タイプ;
        this.is画面 = is画面;
        this.isメニュー = isメニュー;
        this.is保険者 = is保険者;
        this.is審査会開催予定日 = is審査会開催予定日;
        this.is日付範囲開始 = is日付範囲開始;
        this.is日付範囲終了 = is日付範囲終了;
        this.is一次判定日 = is一次判定日;
        this.is主治医意見書受領日 = is主治医意見書受領日;
        this.is申請日 = is申請日;
        this.is認定調査結果受領日 = is認定調査結果受領日;
    }

    /**
     * イメージ情報マスキングパラメータークラス作成
     *
     * @param 市町村コード 市町村コード
     * @param 日付範囲開始 日付範囲開始
     * @param 日付範囲終了 日付範囲終了
     * @param 検索対象 検索対象
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @return イメージ情報マスキングパラメータークラス
     */
    public static ImageJohoMaskingParameter createImageJohoMaskingParameter(
            LasdecCode 市町村コード, FlexibleDate 日付範囲開始,
            FlexibleDate 日付範囲終了, RString 検索対象,
            List<RString> 申請書管理番号リスト) {
        boolean is画面 = false;
        boolean isメニュー = true;
        boolean is用紙タイプ = false;
        boolean is保険者 = false;
        boolean is審査会開催予定日 = false;
        boolean is日付範囲開始 = false;
        boolean is日付範囲終了 = false;
        boolean is一次判定日 = false;
        boolean is主治医意見書受領日 = false;
        boolean is認定調査結果受領日 = false;
        boolean is申請日 = false;
        if (申請書管理番号リスト != null && !申請書管理番号リスト.isEmpty()) {
            is画面 = true;
            isメニュー = false;
        }
        if (市町村コード != null && !市町村コード.isEmpty()) {
            is保険者 = true;
        }
        RString 用紙タイプ = DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (用紙タイプ.equals(new RString("1")) || 用紙タイプ.equals(new RString("3")) || 用紙タイプ.equals(new RString("2"))) {
            is用紙タイプ = true;
        }
        if (日付範囲開始 != null && !日付範囲開始.isEmpty()) {
            is日付範囲開始 = true;
        }
        if (日付範囲終了 != null && !日付範囲終了.isEmpty()) {
            is日付範囲終了 = true;
        }
        if (検索対象.equals(new RString("1"))) {
            is審査会開催予定日 = true;
        }
        if (検索対象.equals(new RString("2"))) {
            is一次判定日 = true;
        }
        if (検索対象.equals(new RString("3"))) {
            is主治医意見書受領日 = true;
        }
        if (検索対象.equals(new RString("4"))) {
            is認定調査結果受領日 = true;
        }
        if (検索対象.equals(new RString("5"))) {
            is申請日 = true;
        }
        return new ImageJohoMaskingParameter(市町村コード, 日付範囲開始, 日付範囲終了,
                ShoriJotaiKubun.取下.getコード(), ShoriJotaiKubun.延期.getコード(),
                TokkijikoTextImageKubun.イメージ.getコード(), new RString("001"), 申請書管理番号リスト,
                is用紙タイプ, is画面, isメニュー, is保険者, is審査会開催予定日, is日付範囲開始, is日付範囲終了,
                is一次判定日, is主治医意見書受領日, is認定調査結果受領日, is申請日);
    }
}
