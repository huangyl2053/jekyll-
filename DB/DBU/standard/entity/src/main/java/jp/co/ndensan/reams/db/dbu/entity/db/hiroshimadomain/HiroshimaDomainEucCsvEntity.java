/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.hiroshimadomain;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HiroshimaDomainEucCsvEntity {

    @CsvField(order = 10, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 20, name = "氏名カナ")
    private final RString 氏名カナ;
    @CsvField(order = 30, name = "氏名")
    private final RString 氏名;
    @CsvField(order = 40, name = "旧住民コード")
    private final RString 旧住民コード;
    @CsvField(order = 50, name = "前住所")
    private final RString 前住所;
    @CsvField(order = 60, name = "転出予定日")
    private final RString 転出予定日;
    @CsvField(order = 70, name = "転出確定日")
    private final RString 転出確定日;
    @CsvField(order = 80, name = "転出確定通知日")
    private final RString 転出確定通知日;
    @CsvField(order = 90, name = "処理日")
    private final RString 処理日;
    @CsvField(order = 100, name = "新住民コード")
    private final RString 新住民コード;
    @CsvField(order = 110, name = "現住所")
    private final RString 現住所;
    @CsvField(order = 120, name = "登録異動日")
    private final RString 登録異動日;
    @CsvField(order = 130, name = "登録届出日")
    private final RString 登録届出日;
    @CsvField(order = 140, name = "異動情報")
    private final RString 異動情報;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 氏名カナ 氏名カナ
     * @param 氏名 氏名
     * @param 旧住民コード 旧住民コード
     * @param 前住所 前住所
     * @param 転出予定日 転出予定日
     * @param 転出確定日 転出確定日
     * @param 転出確定通知日 転出確定通知日
     * @param 処理日 処理日
     * @param 新住民コード 新住民コード
     * @param 現住所 現住所
     * @param 登録異動日 登録異動日
     * @param 登録届出日 登録届出日
     * @param 異動情報 異動情報
     */
    public HiroshimaDomainEucCsvEntity(RString 被保険者番号, RString 氏名カナ, RString 氏名, RString 旧住民コード,
            RString 前住所, RString 転出予定日, RString 転出確定日,
            RString 転出確定通知日, RString 処理日, RString 新住民コード,
            RString 現住所, RString 登録異動日, RString 登録届出日, RString 異動情報) {
        this.被保険者番号 = 被保険者番号;
        this.氏名カナ = 氏名カナ;
        this.氏名 = 氏名;
        this.旧住民コード = 旧住民コード;
        this.前住所 = 前住所;
        this.転出予定日 = 転出予定日;
        this.転出確定日 = 転出確定日;
        this.転出確定通知日 = 転出確定通知日;
        this.処理日 = 処理日;
        this.新住民コード = 新住民コード;
        this.現住所 = 現住所;
        this.登録異動日 = 登録異動日;
        this.登録届出日 = 登録届出日;
        this.異動情報 = 異動情報;
    }
}
