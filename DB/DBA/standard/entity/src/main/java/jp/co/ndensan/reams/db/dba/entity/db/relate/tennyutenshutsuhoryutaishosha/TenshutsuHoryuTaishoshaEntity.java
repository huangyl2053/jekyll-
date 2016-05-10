/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshutsuhoryutaishosha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 転入 広域保留対象者情報の取得処理のEntity。
 *
 * @reamsid_L DBA-0470-010 wangxiaodong
 */
public class TenshutsuHoryuTaishoshaEntity {

    private ShikibetsuCode 識別コード;
    private HihokenshaNo 被保険者番号;
    private Decimal 履歴番号;
    private LasdecCode 市町村コード;
    private RString 住民種別コード;
    private AtenaMeisho 宛名氏名;
    private AtenaKanaMeisho 宛名カナ氏名;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private RString 異動事由コード;
    private FlexibleDate 登録異動年月日;
    private AtenaJusho 住所;

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return 履歴番号;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param 履歴番号 Decimal
     */
    public void set履歴番号(Decimal 履歴番号) {
        this.履歴番号 = 履歴番号;
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return 市町村コード;
    }

    /**
     * 市町村コードのsetメソッドです。
     *
     * @param 市町村コード LasdecCode
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        this.市町村コード = 市町村コード;
    }

    /**
     * 住民種別コードのgetメソッドです。
     *
     * @return 住民種別コード
     */
    public RString get住民種別コード() {
        return 住民種別コード;
    }

    /**
     * 住民種別コードのsetメソッドです。
     *
     * @param 住民種別コード RString
     */
    public void set住民種別コード(RString 住民種別コード) {
        this.住民種別コード = 住民種別コード;
    }

    /**
     * 宛名氏名のgetメソッドです。
     *
     * @return 宛名氏名
     */
    public AtenaMeisho get宛名氏名() {
        return 宛名氏名;
    }

    /**
     * 宛名氏名のsetメソッドです。
     *
     * @param 宛名氏名 AtenaMeisho
     */
    public void set宛名氏名(AtenaMeisho 宛名氏名) {
        this.宛名氏名 = 宛名氏名;
    }

    /**
     * 宛名カナ氏名のgetメソッドです。
     *
     * @return 宛名カナ氏名
     */
    public AtenaKanaMeisho get宛名カナ氏名() {
        return 宛名カナ氏名;
    }

    /**
     * 宛名カナ氏名のsetメソッドです。
     *
     * @param 宛名カナ氏名 AtenaKanaMeisho
     */
    public void set宛名カナ氏名(AtenaKanaMeisho 宛名カナ氏名) {
        this.宛名カナ氏名 = 宛名カナ氏名;
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return 生年月日;
    }

    /**
     * 生年月日のsetメソッドです。
     *
     * @param 生年月日 FlexibleDate
     */
    public void set生年月日(FlexibleDate 生年月日) {
        this.生年月日 = 生年月日;
    }

    /**
     * 性別コードのgetメソッドです。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return 性別コード;
    }

    /**
     * 性別コードのsetメソッドです。
     *
     * @param 性別コード RString
     */
    public void set性別コード(RString 性別コード) {
        this.性別コード = 性別コード;
    }

    /**
     * 異動事由コードのgetメソッドです。
     *
     * @return 異動事由コード
     */
    public RString get異動事由コード() {
        return 異動事由コード;
    }

    /**
     * 異動事由コードのsetメソッドです。
     *
     * @param 異動事由コード RString
     */
    public void set異動事由コード(RString 異動事由コード) {
        this.異動事由コード = 異動事由コード;
    }

    /**
     * get登録異動年月日のgetメソッドです。
     *
     * @return 登録異動年月日
     */
    public FlexibleDate get登録異動年月日() {
        return 登録異動年月日;
    }

    /**
     * get登録異動年月日のsetメソッドです。
     *
     * @param 登録異動年月日 FlexibleDate
     */
    public void set登録異動年月日(FlexibleDate 登録異動年月日) {
        this.登録異動年月日 = 登録異動年月日;
    }

    /**
     * get住所のgetメソッドです。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return 住所;
    }

    /**
     * get住所のsetメソッドです。
     *
     * @param 住所 AtenaJusho
     */
    public void set住所(AtenaJusho 住所) {
        this.住所 = 住所;
    }
}
