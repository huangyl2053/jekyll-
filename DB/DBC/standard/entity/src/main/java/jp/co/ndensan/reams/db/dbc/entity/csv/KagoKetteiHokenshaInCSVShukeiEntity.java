/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * KagoKetteiTsuchishoJyohoHokenshabunCSVShukeiEntityのcsv項目定義クラスです
 */
public class KagoKetteiHokenshaInCSVShukeiEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString kokanShikibetsuNo;
    @CsvField(order = 20, name = "帳票レコード種別")
    private RString chouhyouCodeShubetsu;
    @CsvField(order = 30, name = "介護給付費件数")
    private RString kaigoKyufuhiKensu;
    @CsvField(order = 40, name = "介護給付費単位数")
    private RString kaigoKyufuhiTanisu;
    @CsvField(order = 50, name = "介護給付費保険者負担額")
    private RString kaigoKyufuhiFutangaku;
    @CsvField(order = 60, name = "高額介護サービス費件数")
    private RString kogakuServicehiKensu;
    @CsvField(order = 70, name = "高額介護サービス費単位数")
    private RString kogakuServicehiTanisu;
    @CsvField(order = 80, name = "高額介護サービス費保険者負担額")
    private RString kogakuServicehiFutangaku;
    @CsvField(order = 90, name = "特定入所者介護サービス費等件数")
    private RString tokuteiNyushoshaServicehiKensu;
    @CsvField(order = 100, name = "特定入所者介護サービス費等費用額")
    private RString tokuteiNyushoshaServicehiTanisu;
    @CsvField(order = 110, name = "特定入所者介護サービス費等保険者負担額")
    private RString tokuteiNyushoshaServicehiFutangaku;

    /**
     * コンストラクタです。
     */
    public KagoKetteiHokenshaInCSVShukeiEntity() {

    }

    /**
     * getKokanShikibetsuNo
     *
     * @return kokanShikibetsuNo
     */
    public RString getKokanShikibetsuNo() {
        return kokanShikibetsuNo;
    }

    /**
     * setKokanShikibetsuNo
     *
     * @param kokanShikibetsuNo RString
     */
    public void setKokanShikibetsuNo(RString kokanShikibetsuNo) {
        this.kokanShikibetsuNo = kokanShikibetsuNo;
    }

    /**
     * getChouhyouCodeShubetsu
     *
     * @return chouhyouCodeShubetsu
     */
    public RString getChouhyouCodeShubetsu() {
        return chouhyouCodeShubetsu;
    }

    /**
     * setChouhyouCodeShubetsu
     *
     * @param chouhyouCodeShubetsu RString
     */
    public void setChouhyouCodeShubetsu(RString chouhyouCodeShubetsu) {
        this.chouhyouCodeShubetsu = chouhyouCodeShubetsu;
    }

    /**
     * getKaigoKyufuhiKensu
     *
     * @return kaigoKyufuhiKensu
     */
    public RString getKaigoKyufuhiKensu() {
        return kaigoKyufuhiKensu;
    }

    /**
     * setKaigoKyufuhiKensu
     *
     * @param kaigoKyufuhiKensu RString
     */
    public void setKaigoKyufuhiKensu(RString kaigoKyufuhiKensu) {
        this.kaigoKyufuhiKensu = kaigoKyufuhiKensu;
    }

    /**
     * getKaigoKyufuhiTanisu
     *
     * @return kaigoKyufuhiTanisu
     */
    public RString getKaigoKyufuhiTanisu() {
        return kaigoKyufuhiTanisu;
    }

    /**
     * setKaigoKyufuhiTanisu
     *
     * @param kaigoKyufuhiTanisu RString
     */
    public void setKaigoKyufuhiTanisu(RString kaigoKyufuhiTanisu) {
        this.kaigoKyufuhiTanisu = kaigoKyufuhiTanisu;
    }

    /**
     * getKaigoKyufuhiFutangaku
     *
     * @return kaigoKyufuhiFutangaku
     */
    public RString getKaigoKyufuhiFutangaku() {
        return kaigoKyufuhiFutangaku;
    }

    /**
     * setKaigoKyufuhiFutangaku
     *
     * @param kaigoKyufuhiFutangaku RString
     */
    public void setKaigoKyufuhiFutangaku(RString kaigoKyufuhiFutangaku) {
        this.kaigoKyufuhiFutangaku = kaigoKyufuhiFutangaku;
    }

    /**
     * getKogakuServicehiKensu
     *
     * @return kogakuServicehiKensu
     */
    public RString getKogakuServicehiKensu() {
        return kogakuServicehiKensu;
    }

    /**
     * setKogakuServicehiKensu
     *
     * @param kogakuServicehiKensu RString
     */
    public void setKogakuServicehiKensu(RString kogakuServicehiKensu) {
        this.kogakuServicehiKensu = kogakuServicehiKensu;
    }

    /**
     * getKogakuServicehiTanisu
     *
     * @return kogakuServicehiTanisu
     */
    public RString getKogakuServicehiTanisu() {
        return kogakuServicehiTanisu;
    }

    /**
     * setKogakuServicehiTanisu
     *
     * @param kogakuServicehiTanisu RString
     */
    public void setKogakuServicehiTanisu(RString kogakuServicehiTanisu) {
        this.kogakuServicehiTanisu = kogakuServicehiTanisu;
    }

    /**
     * getKogakuServicehiFutangaku
     *
     * @return kogakuServicehiFutangaku
     */
    public RString getKogakuServicehiFutangaku() {
        return kogakuServicehiFutangaku;
    }

    /**
     * setKogakuServicehiFutangaku
     *
     * @param kogakuServicehiFutangaku RString
     */
    public void setKogakuServicehiFutangaku(RString kogakuServicehiFutangaku) {
        this.kogakuServicehiFutangaku = kogakuServicehiFutangaku;
    }

    /**
     * getTokuteiNyushoshaServicehiKensu
     *
     * @return tokuteiNyushoshaServicehiKensu
     */
    public RString getTokuteiNyushoshaServicehiKensu() {
        return tokuteiNyushoshaServicehiKensu;
    }

    /**
     * setTokuteiNyushoshaServicehiKensu
     *
     * @param tokuteiNyushoshaServicehiKensu RString
     */
    public void setTokuteiNyushoshaServicehiKensu(RString tokuteiNyushoshaServicehiKensu) {
        this.tokuteiNyushoshaServicehiKensu = tokuteiNyushoshaServicehiKensu;
    }

    /**
     * getTokuteiNyushoshaServicehiTanisu
     *
     * @return tokuteiNyushoshaServicehiTanisu
     */
    public RString getTokuteiNyushoshaServicehiTanisu() {
        return tokuteiNyushoshaServicehiTanisu;
    }

    /**
     * setTokuteiNyushoshaServicehiTanisu
     *
     * @param tokuteiNyushoshaServicehiTanisu RString
     */
    public void setTokuteiNyushoshaServicehiTanisu(RString tokuteiNyushoshaServicehiTanisu) {
        this.tokuteiNyushoshaServicehiTanisu = tokuteiNyushoshaServicehiTanisu;
    }

    /**
     * getTokuteiNyushoshaServicehiFutangaku
     *
     * @return tokuteiNyushoshaServicehiFutangaku
     */
    public RString getTokuteiNyushoshaServicehiFutangaku() {
        return tokuteiNyushoshaServicehiFutangaku;
    }

    /**
     * setTokuteiNyushoshaServicehiFutangaku
     *
     * @param tokuteiNyushoshaServicehiFutangaku RString
     */
    public void setTokuteiNyushoshaServicehiFutangaku(RString tokuteiNyushoshaServicehiFutangaku) {
        this.tokuteiNyushoshaServicehiFutangaku = tokuteiNyushoshaServicehiFutangaku;
    }

}
