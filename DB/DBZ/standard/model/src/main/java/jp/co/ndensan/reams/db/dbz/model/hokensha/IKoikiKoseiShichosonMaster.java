/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ForeignersNameOutput;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TopPriorityArea;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GappeiKyuShichosonHyoji;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.RokenJukyushaNoTaikei;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.UnyoKeitaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.GappeiChiikiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.KokuhorenKoikiShichosonNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.RokenShichosonNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域構成市町村です。
 *
 * @author N3327 三浦 凌
 */
public interface IKoikiKoseiShichosonMaster extends IHokensha {

    /**
     * 市町村識別IDを返します。
     *
     * @return {@link ShichosonShikibetsuID 市町村識別ID}
     */
    ShichosonShikibetsuID get市町村識別ID();

    /**
     * 市町村コードを返します。
     *
     * @return {@link LasdecCode 市町村コード}
     */
    LasdecCode get市町村コード();

    /**
     * 国保連広域内市町村番号を返します。
     *
     * @return {@link KokuhorenKoikiShichosonNo 国保連広域内市町村番号}
     */
    KokuhorenKoikiShichosonNo get国保連広域内市町村番号();

    /**
     * 市町村名を返します。
     *
     * @return 市町村名
     */
    RString get市町村名();

    /**
     * 都道府県名を返します。
     *
     * @return 都道府県名
     */
    RString get都道府県名();

    /**
     * 群名を返します。
     *
     * @return 群名
     */
    RString get郡名();

    /**
     * 最優先地区を返します。
     *
     * @return {@link TopPriorityArea 最優先地区}
     */
    TopPriorityArea get最優先地区();

    /**
     * 外国人の氏名の表示方法を返します。
     *
     * @return {@link ForeignersNameOutput 外国人}
     */
    ForeignersNameOutput get外国人氏名表示方法();

    /**
     * 老人保健市町村番号を返します。
     *
     * @return {@link RokenShichosonNo 老人保健市町村番号}
     */
    RokenShichosonNo get老人保健市町村番号();

    /**
     * 老人保健受給者番号体系を返します。
     *
     * @return {@link RokenJukyushaNoTaikei 老人保健受給者番号体系}
     */
    RokenJukyushaNoTaikei get老人保健受給者番号体系();

    /**
     * 移行日を返します。
     *
     * @return 移行日
     */
    FlexibleDate get移行日();

    /**
     * 広域への加入日を返します。
     *
     * @return 加入日
     */
    FlexibleDate get加入日();

    /**
     * 広域からの脱退日を返します。
     *
     * @return 広域からの脱退日
     */
    FlexibleDate get離脱日();

    /**
     * 合併した旧市町村かそうでないかの区分を返します。
     *
     * @return {@link GappeiKyuShichosonKubun 合併旧市町村区分}
     */
    GappeiKyuShichosonKubun get合併旧市町村区分();

    /**
     * 合併旧市町村で表示をする必要がある市町村かどうかを返します。
     *
     * @return {@link GappeiKyuShichosonHyoji 合併旧市町村表示有無}
     */
    GappeiKyuShichosonHyoji get合併旧市町村表示有無();

    /**
     * 合併地域番号を返します。
     *
     * @return {@link GappeiChiikiNo get合併情報リンク番号}
     */
    GappeiChiikiNo get合併地域番号();

    /**
     * 運用保険者番号を返します。
     *
     * @return 運用{@link ShoKisaiHokenshaNo 保険者番号}
     */
    ShoKisaiHokenshaNo get運用保険者番号();

    /**
     * 運用開始日を返します。
     *
     * @return 運用開始日
     */
    FlexibleDate get運用開始日();

    /**
     * 運用終了日を返します。
     *
     * @return 運用終了日
     */
    FlexibleDate get運用終了日();

    /**
     * 運用形態区分を返します。
     *
     * @return {@link UnyoKeitaiKubun 運用形態区分}
     */
    UnyoKeitaiKubun get運用形態区分();
}
