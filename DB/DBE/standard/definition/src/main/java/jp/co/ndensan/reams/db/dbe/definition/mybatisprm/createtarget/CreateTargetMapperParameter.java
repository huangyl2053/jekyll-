/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.createtarget;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信データ出力のパラメータクラス。
 *
 * @reamsid_L DBE-1680-010 zhangzhiming
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class CreateTargetMapperParameter {

    private final RString データ出力;
    private final List<RString> 申請書管理番号;
    private final FlexibleDate 申請日_開始;
    private final FlexibleDate 申請日_終了;
    private final FlexibleDate 認定日_開始;
    private final FlexibleDate 認定日_終了;
    private final int 件数;
    private final boolean detaFlg;
    private final boolean shinnseiKaishi;
    private final boolean shinnseiShuuryou;
    private final boolean ninnteiKaishi;
    private final boolean ninnteiShuuryou;
    private static final RString データ選択 = new RString("key0");
    private final RString イメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分,
            RDate.getNowDate(), SubGyomuCode.DBE認定支援);

    private CreateTargetMapperParameter(RString データ出力, List<RString> 申請書管理番号, FlexibleDate 申請日_開始, FlexibleDate 申請日_終了,
            FlexibleDate 認定日_開始, FlexibleDate 認定日_終了, int 件数, boolean detaFlg, boolean shinnseiKaishi,
            boolean shinnseiShuuryou, boolean ninnteiKaishi, boolean ninnteiShuuryou) {
        this.データ出力 = データ出力;
        this.申請書管理番号 = 申請書管理番号;
        this.申請日_開始 = 申請日_開始;
        this.申請日_終了 = 申請日_終了;
        this.認定日_開始 = 認定日_開始;
        this.認定日_終了 = 認定日_終了;
        this.件数 = 件数;
        this.detaFlg = detaFlg;
        this.shinnseiKaishi = shinnseiKaishi;
        this.shinnseiShuuryou = shinnseiShuuryou;
        this.ninnteiKaishi = ninnteiKaishi;
        this.ninnteiShuuryou = ninnteiShuuryou;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param データ出力 データ出力
     * @param 申請日_開始 申請日_開始
     * @param 申請日_終了 申請日_終了
     * @param 認定日_開始 認定日_開始
     * @param 認定日_終了 認定日_終了
     * @param 件数 件数
     * @param detaFlg データ出力Flg
     * @param shinnseiKaishi 申請日_開始Flg
     * @param shinnseiShuuryou 申請日_終了Flg
     * @param ninnteiKaishi 認定日_開始Flg
     * @param ninnteiShuuryou 認定日_終了Flg
     * @return センター送信データパラメータ
     */
    public static CreateTargetMapperParameter createParam(RString データ出力, FlexibleDate 申請日_開始, FlexibleDate 申請日_終了,
            FlexibleDate 認定日_開始, FlexibleDate 認定日_終了, int 件数, boolean detaFlg, boolean shinnseiKaishi,
            boolean shinnseiShuuryou, boolean ninnteiKaishi, boolean ninnteiShuuryou) {
        detaFlg = false;
        shinnseiKaishi = false;
        shinnseiShuuryou = false;
        ninnteiKaishi = false;
        ninnteiShuuryou = false;
        if (データ選択.equals(データ出力)) {
            detaFlg = true;
        }
        if (申請日_開始 != null && !申請日_開始.isEmpty()) {
            shinnseiKaishi = true;
        }
        if (申請日_終了 != null && !申請日_終了.isEmpty()) {
            shinnseiShuuryou = true;
        }
        if (認定日_開始 != null && !認定日_開始.isEmpty()) {
            ninnteiKaishi = true;
        }
        if (認定日_終了 != null && !認定日_終了.isEmpty()) {
            ninnteiShuuryou = true;
        }
        return new CreateTargetMapperParameter(データ出力, null, 申請日_開始, 申請日_終了, 認定日_開始, 認定日_終了, 件数,
                detaFlg, shinnseiKaishi, shinnseiShuuryou, ninnteiKaishi, ninnteiShuuryou);
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return センター送信Csvデータパラメータ
     */
    public static CreateTargetMapperParameter createCsvDataParam(List<RString> 申請書管理番号) {
        return new CreateTargetMapperParameter(RString.EMPTY, 申請書管理番号, FlexibleDate.MAX, FlexibleDate.MAX,
                FlexibleDate.MAX, FlexibleDate.MAX, 0, true, true, true, true, true);
    }
}
