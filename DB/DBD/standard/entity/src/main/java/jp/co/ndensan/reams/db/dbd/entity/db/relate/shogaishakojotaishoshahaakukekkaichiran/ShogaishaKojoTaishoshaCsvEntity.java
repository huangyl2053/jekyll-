/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shogaishakojotaishoshahaakukekkaichiran;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 控除対象者データのentityです。
 *
 * @reamsid_L DBD-3850-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishaKojoTaishoshaCsvEntity {

    @CsvField(order = 1, name = "証記載保険者番号")
    private RString shoKisaiHokenshaNo;

    @CsvField(order = 2, name = "被保険者番号")
    private RString hihokenshaNo;

    @CsvField(order = 3, name = "履歴番号")
    private RString rirekiNo;

    @CsvField(order = 4, name = "対象年度")
    private RString taishoNendo;

    @CsvField(order = 5, name = "申請年月日")
    private RString shinseiYMD;

    @CsvField(order = 6, name = "決定年月日")
    private RString ketteiYMD;

    @CsvField(order = 7, name = "基準日")
    private RString kijunYMD;

    @CsvField(order = 8, name = "把握日")
    private RString haakuYMD;

    @CsvField(order = 9, name = "申請事由")
    private RString shinseiJiyu;

    @CsvField(order = 10, name = "認定区分")
    private RString ninteiKubun;

    @CsvField(order = 11, name = "認定内容")
    private RString ninteiNaiyo;

    @CsvField(order = 12, name = "認知症高齢者の日常生活自立度コード")
    private RString ninchishoNichijoSeikatsuJiritsudoCode;

    @CsvField(order = 13, name = "障害高齢者の日常生活自立度コード")
    private RString shogaiNichijoSeikatsuJiritsudoCode;

    @CsvField(order = 14, name = "障がい者手帳有無")
    private RString shogaishaTechoUmu;

    @CsvField(order = 15, name = "資格喪失事由コード")
    private RString shikakuSoshitsuJiyuCode;

    @CsvField(order = 16, name = "資格喪失年月日")
    private RString shikakuSoshitsuYMD;

    @CsvField(order = 17, name = "認定証発行対象外フラグ")
    private RString ninteishoHakkoTaishogai;

    /**
     * コンストラクタです。
     */
    public ShogaishaKojoTaishoshaCsvEntity() {
    }

    /**
     * コンストラクタです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @param hihokenshaNo 被保険者番号
     * @param rirekiNo 履歴番号
     * @param taishoNendo 対象年度
     * @param shinseiYMD 申請年月日
     * @param ketteiYMD 決定年月日
     * @param kijunYMD 基準日
     * @param haakuYMD 把握日
     * @param shinseiJiyu 申請事由
     * @param ninteiKubun 認定区分
     * @param ninteiNaiyo 認定内容
     * @param ninchishoNichijoSeikatsuJiritsudoCode 認知症高齢者の日常生活自立度コード
     * @param shogaiNichijoSeikatsuJiritsudoCode 障害高齢者の日常生活自立度コード
     * @param shogaishaTechoUmu 障がい者手帳有無
     * @param shikakuSoshitsuJiyuCode 資格喪失事由コード
     * @param shikakuSoshitsuYMD 資格喪失年月日
     * @param ninteishoHakkoTaishogai 認定証発行対象外フラグ
     *
     *
     */
    public ShogaishaKojoTaishoshaCsvEntity(RString shoKisaiHokenshaNo,
            RString hihokenshaNo,
            RString rirekiNo,
            RString taishoNendo,
            RString shinseiYMD,
            RString ketteiYMD,
            RString kijunYMD,
            RString haakuYMD,
            RString shinseiJiyu,
            RString ninteiKubun,
            RString ninteiNaiyo,
            RString ninchishoNichijoSeikatsuJiritsudoCode,
            RString shogaiNichijoSeikatsuJiritsudoCode,
            RString shogaishaTechoUmu,
            RString shikakuSoshitsuJiyuCode,
            RString shikakuSoshitsuYMD,
            RString ninteishoHakkoTaishogai) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.hihokenshaNo = hihokenshaNo;
        this.rirekiNo = rirekiNo;
        this.taishoNendo = taishoNendo;
        this.shinseiYMD = shinseiYMD;
        this.ketteiYMD = ketteiYMD;
        this.kijunYMD = kijunYMD;
        this.haakuYMD = haakuYMD;
        this.shinseiJiyu = shinseiJiyu;
        this.ninteiKubun = ninteiKubun;
        this.ninteiNaiyo = ninteiNaiyo;
        this.ninchishoNichijoSeikatsuJiritsudoCode = ninchishoNichijoSeikatsuJiritsudoCode;
        this.shogaiNichijoSeikatsuJiritsudoCode = shogaiNichijoSeikatsuJiritsudoCode;
        this.shogaishaTechoUmu = shogaishaTechoUmu;
        this.shikakuSoshitsuJiyuCode = shikakuSoshitsuJiyuCode;
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
        this.ninteishoHakkoTaishogai = ninteishoHakkoTaishogai;

    }
}
