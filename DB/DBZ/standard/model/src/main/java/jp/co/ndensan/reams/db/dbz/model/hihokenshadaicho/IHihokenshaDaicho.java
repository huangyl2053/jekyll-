/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuJutokuKaijo;
//TODO n3327 三浦凌 URに作成した以下のクラスがリリースされたらコメントアウトを解除する。
//import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoShikakuHenkoJiyu;
//import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoShikakuJutokuKaijoJiyu;
//import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoShikakuJutokuTekiyoJiyu;
//import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoShikakuShutokuJiyu;
//import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KofuJiyu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * HihokenshaDaichoの基本要素です。
 *
 * @author n8178 城間篤人
 */
public interface IHihokenshaDaicho {

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    LasdecCode get市町村コード();

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    HihokenshaNo get被保険者番号();

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    YMDHMS get処理日時();

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    ShikibetsuCode get識別コード();

    /**
     * 旧市町村コードを返します。
     *
     * @return 旧市町村コード
     */
    LasdecCode get旧市町村コード();

    /**
     * 資格の取得日を返します。
     *
     * @return 資格取得年月日
     */
    FlexibleDate get資格取得年月日();

    /**
     * 取得届出日を返します。
     *
     * @return 資格取得届出年月日
     */
    FlexibleDate get資格取得届出年月日();

    /**
     * 資格の取得事由を返します。
     *
     * @return 資格取得事由
     */
//    KaigoShikakuShutokuJiyu get資格取得事由();
    /**
     * 資格の喪失日を返します。
     *
     * @return 資格喪失年月日
     */
    FlexibleDate get資格喪失年月日();

    /**
     * 喪失届出日を返します。
     *
     * @return 資格喪失届出年月日
     */
    FlexibleDate get資格喪失届出年月日();

    /**
     * 資格の喪失事由を返します。
     *
     * @return 資格喪失事由コード
     */
//    KaigoShikakuSoshitsuJiyu get資格喪失事由();
    /**
     * 被保険者が第1号被保険者・第2号被保険者のどちらであるかを示す、被保険者区分を返します。
     *
     * @return 被保険者区分コード
     */
    ShikakuHihokenshaKubun get被保険者区分();

    /**
     * 資格関連異動に変更があった日付を返します。
     *
     * @return 変更日
     */
    FlexibleDate get資格変更年月日();

    /**
     * 変更届出日を返します。
     *
     * @return 変更届出日
     */
    FlexibleDate get資格変更届出年月日();

    /**
     * 変更事由を返します。
     *
     * @return 変更事由
     */
//    KaigoShikakuHenkoJiyu get資格変更事由();
    /**
     * 住所地特例が適用された日付を返します。
     *
     * @return 適用日
     */
    FlexibleDate get住所地特例適用年月日();

    /**
     * 適用届出日を返します。
     *
     * @return 適用届出日
     */
    FlexibleDate get住所地特例適用届出年月日();

    /**
     * 適用事由を返します。
     *
     * @return 適用事由
     */
//    KaigoShikakuJutokuTekiyoJiyu get住所地特例適用事由();
    /**
     * 住所地特例が解除された日付を返します。
     *
     * @return 解除日
     */
    FlexibleDate get住所地特例解除年月日();

    /**
     * 解除届出日を返します。
     *
     * @return 解除届出日
     */
    FlexibleDate get住所地特例解除届出年月日();

    /**
     * 解除事由を返します。
     *
     * @return 解除事由
     */
//    KaigoShikakuJutokuKaijoJiyu get住所地特例解除事由();
    //TODO #52997 以下のgetterの戻り値は、modelの対応する値を返すように実装する。
    /**
     * 第1号被保険者となる年齢（65歳）に到達する日付を返します。
     *
     * @return 第1号被保険者年齢到達日
     */
    FlexibleDate get第1号資格取得年月日();

    /**
     * 資格者が住所地特例者か否かを示す、住所地特例フラグを返します。
     *
     * @return 住所地特例フラグ
     */
    JushochiTokureishaKubun get住所地特例フラグ();

    /**
     * 広域内住所地特例者か否かを表す区分を返します。
     *
     * @return 広域内住所地特例区分
     */
    KoikinaiJushochitokureishaKubun get広域内住所地特例区分();

    /**
     * 再交付区分を返します。
     *
     * @return 再交付区分
     */
    HihokenshashoSaikofuKubun get再交付区分();

    /**
     * 再交付事由を返します。
     *
     * @return 再交付事由コード
     */
    KofuJiyu get再交付事由コード();

    /**
     * 帳票交付履歴IDを返します。
     *
     * @return 帳票交付履歴ID
     */
    RString get帳票交付履歴ID();

    /**
     * 広住特措置元市町村コードを返します。
     *
     * @return 広住特措置元市町村コード
     */
    LasdecCode get広住特措置元市町村コード();

}
