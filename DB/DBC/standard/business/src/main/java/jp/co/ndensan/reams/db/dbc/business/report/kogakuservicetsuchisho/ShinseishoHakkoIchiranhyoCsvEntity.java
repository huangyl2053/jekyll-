/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShinseishoHakkoIchiranhyoCsvEntity {

    @CsvField(order = 1, name = "発行日時")
    private final RString hakkoNichiji;
    @CsvField(order = 2, name = "連番")
    private final RString renban;
    @CsvField(order = 3, name = "被保険者番号")
    private final RString hihokenshaNo;
    @CsvField(order = 4, name = "サービス提供年月")
    private final RString serviceTeikyoYM;
    @CsvField(order = 5, name = "被保険者名")
    private final RString hihokenshaMei;
    @CsvField(order = 6, name = "郵便番号")
    private final RString yubinNo;
    @CsvField(order = 7, name = "住所")
    private final RString jusho;
    @CsvField(order = 8, name = "行政区コード")
    private final RString gyoseikuCode;
    @CsvField(order = 9, name = "行政区")
    private final RString gyoseikuName;
    @CsvField(order = 10, name = "旧措置")
    private final RString kyusochi;
    @CsvField(order = 11, name = "要介護状態区分")
    private final RString yokaigoJotaiKubun;
    @CsvField(order = 12, name = "認定有効開始年月日")
    private final RString ninteiYukoKikanKaishiYMD;
    @CsvField(order = 13, name = "有効期間終了年月日")
    private final RString ninteiYukoKikanShuryoYMD;
    @CsvField(order = 14, name = "自己負担額")
    private final RString jikoFutangaku;
    @CsvField(order = 15, name = "支給（予定）金額")
    private final RString shikyuKingaku;
    @CsvField(order = 16, name = "社福軽減")
    private final RString shafukuKeigen;
    @CsvField(order = 17, name = "自動償還")
    private final RString jidoShokan;
    @CsvField(order = 18, name = "資格喪失")
    private final RString shikakuSoshitsu;

    /**
     * コンストラクタです。
     *
     * @param hakkoNichiji 発行日時
     * @param renban 連番
     * @param hihokenshaNo 被保険者番号
     * @param serviceTeikyoYM サービス提供年月
     * @param hihokenshaMei 被保険者名
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param gyoseikuCode 行政区コード
     * @param gyoseikuName 行政区
     * @param kyusochi 旧措置
     * @param yokaigoJotaiKubun 要介護状態区分
     * @param ninteiYukoKikanKaishiYMD 認定有効開始年月日
     * @param ninteiYukoKikanShuryoYMD 有効期間終了年月日
     * @param jikoFutangaku 自己負担額
     * @param shikyuKingaku 支給（予定）金額
     * @param shafukuKeigen 社福軽減
     * @param jidoShokan 自動償還
     * @param shikakuSoshitsu 資格喪失
     */
    public ShinseishoHakkoIchiranhyoCsvEntity(RString hakkoNichiji, RString renban, RString hihokenshaNo, RString serviceTeikyoYM,
            RString hihokenshaMei, RString yubinNo, RString jusho, RString gyoseikuCode, RString gyoseikuName, RString kyusochi,
            RString yokaigoJotaiKubun, RString ninteiYukoKikanKaishiYMD, RString ninteiYukoKikanShuryoYMD, RString jikoFutangaku,
            RString shikyuKingaku, RString shafukuKeigen, RString jidoShokan, RString shikakuSoshitsu) {
        this.hakkoNichiji = hakkoNichiji;
        this.renban = renban;
        this.hihokenshaNo = hihokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.hihokenshaMei = hihokenshaMei;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.gyoseikuCode = gyoseikuCode;
        this.gyoseikuName = gyoseikuName;
        this.kyusochi = kyusochi;
        this.yokaigoJotaiKubun = yokaigoJotaiKubun;
        this.ninteiYukoKikanKaishiYMD = ninteiYukoKikanKaishiYMD;
        this.ninteiYukoKikanShuryoYMD = ninteiYukoKikanShuryoYMD;
        this.jikoFutangaku = jikoFutangaku;
        this.shikyuKingaku = shikyuKingaku;
        this.shafukuKeigen = shafukuKeigen;
        this.jidoShokan = jidoShokan;
        this.shikakuSoshitsu = shikakuSoshitsu;
    }

}
