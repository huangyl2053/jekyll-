/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kogakugassankaigo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanKaigoServicehiShikyuKofuShinseishoItem {

    private final RString birthYMD;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString kaigoHokenshaName;
    private final RString hokenshaNo;
    private final RString hihokenshaNo;
    private final RString remban;
    private final RString ninshoshaYakushokuMei;

    /**
     * インスタンスを生成します。
     *
     * @param birthYMD 生年月日
     * @param hihokenshaNameKana フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param kaigoHokenshaName 保険者名称
     * @param hokenshaNo 保険者番号
     * @param hihokenshaNo 被保険者番号
     * @param remban 連番
     * @param ninshoshaYakushokuMei 認証者
     */
    public KogakuGassanKaigoServicehiShikyuKofuShinseishoItem(
            RString birthYMD,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString kaigoHokenshaName,
            RString hokenshaNo,
            RString hihokenshaNo,
            RString remban,
            RString ninshoshaYakushokuMei) {
        this.birthYMD = birthYMD;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.kaigoHokenshaName = kaigoHokenshaName;
        this.hokenshaNo = hokenshaNo;
        this.hihokenshaNo = hihokenshaNo;
        this.remban = remban;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
    }
}
