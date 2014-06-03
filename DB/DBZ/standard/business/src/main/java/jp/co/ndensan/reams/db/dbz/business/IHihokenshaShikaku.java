/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 介護保険被保険者の被保険者台帳上の情報を扱うインタフェースです。
 *
 * @author N3327 三浦 凌
 */
public interface IHihokenshaShikaku extends IHihokenshaNoGettable, IShikibetsuCodeGettable {

    /**
     * 被保険者の資格を管理する、地方公共団体コードを返します。
     *
     * @return {@link LasdecCode 地方公共団体コード}
     */
    LasdecCode get地方公共団体コード();

    /**
     * 被保険者の識別コードを返します。
     *
     * @return {@link ShikibetsuCode 識別コード}
     */
    @Override
    ShikibetsuCode get識別コード();

    /**
     * 被保険者台帳に登録された日時を返します。
     *
     * @return {@link RDateTime 被保険者台帳登録日時}
     */
    RDateTime get被保険者台帳登録日時();

    /**
     * 被保険者の被保険者番号を返します。 <br />
     * 被保険者番号がないとき、nullを返します。
     *
     * @return {@link KaigoHihokenshaNo 被保険者番号}。もしくは、null。
     */
    @Override
    KaigoHihokenshaNo get被保険者番号();

    /**
     * 被保険者の直近の資格異動の分類を返します。
     *
     * @return {@link ShikakuIdoKubun 資格異動区分}
     */
    ShikakuIdoKubun get資格異動区分();

    /**
     * 資格取得に関する結果を取得します。
     *
     * @return 資格取得
     */
    ShikakuShutoku get資格取得();

    /**
     * 第1号被保険者の資格を取得する(またはした)年月日を返します。
     *
     * @return 第1号該当日
     */
    FlexibleDate get第一号年齢到達日();

    /**
     * 被保険者の分類を返します。
     *
     * @return {@link HihokenshaKubun 被保険者区分}
     */
    ShikakuHihokenshaKubun get被保険者区分();

    /**
     * 指定の基準日時点で、被保険者資格を保持しているかどうかを返します。
     *
     * @param baseDate 基準日
     * @return 基準日時点で被保険者資格が資格があるかどうか。
     */
    boolean has被保険者資格At(RDate baseDate);

    /**
     * 資格喪失に関する結果を取得します。
     *
     * @return 資格喪失
     */
    ShikakuSoshitsu get資格喪失();

    /**
     * 資格変更に関する結果を取得します。
     *
     * @return 資格変更
     */
    ShikakuHenko get資格変更();

    /**
     * 住所地特例の適用に関する結果を取得します。
     *
     * @return 住所地特例適用
     */
    JushochitokureiTekiyo get住所地特例適用();

    /**
     * 住所地特例の解除に関する結果を取得します。
     *
     * @return 住所地特例解除
     */
    JushochitokureiKaijo get住所地特例解除();

    /**
     * 住所地特例者かどうかの区分を返します。
     *
     * @return {@link JushochitokureishaKubun 住所地特例者区分}
     */
    JushochiTokureishaKubun get住所地特例者区分();

    /**
     * 広域内の住所地特例者かどうかの区分を返します。
     *
     * @return {@link KoikiJushochitokureishaKubun 広域内住所地特例者区分}
     */
    KoikinaiJushochitokureishaKubun get広域内住所地特例者区分();

    /**
     * 広域内住所地特例の措置元市町村を表す地方公共団体コードを返します。<br />
     * 広域内住所地特例措置元市町村がないとき、nullを返します。
     *
     * @return 広域内の住所地特例措置元の地方公共団体コード。もしくは、null。
     */
    LasdecCode get広域内住所地特例措置元市町村コード();

    /**
     * 合併前の市町村を表す地方公共団体コードを返します。<br />
     * 合併前の市町村がないとき、nullを返します。
     *
     * @return 合併前の地方公共団体コード。もしくは、null。
     */
    LasdecCode get旧市町村コード();

    /**
     * 被保険者証再交付の状況を返します。
     *
     * @return {@link HihokenshashoSaikofu 被保険者証再交付}
     */
    HihokenshashoSaikofu get被保険者証再交付();

    /**
     * IKaigoShikakuへ変換します。
     *
     * @return IKaigoShikaku
     */
    IKaigoShikaku toKaigoShikaku();
}
