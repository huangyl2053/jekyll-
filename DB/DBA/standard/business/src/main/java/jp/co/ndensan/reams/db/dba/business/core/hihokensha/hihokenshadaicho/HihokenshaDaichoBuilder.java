/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.hihokenshadaicho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyoIdentifier;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.jukyushadaicho.JukyushaDaicho;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.jukyushadaicho.JukyushaDaichoIdentifier;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaIdentifier;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaIdentifier;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.shisetsunyutaisho.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link HihokenshaDaicho}の編集を行うビルダークラスです。
 */
public class HihokenshaDaichoBuilder {

    private final DbT1001HihokenshaDaichoEntity entity;
    private final HihokenshaDaichoIdentifier id;
    private final Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho;
    private final Models<IryohokenKanyuJokyoIdentifier, IryohokenKanyuJokyo> iryohokenKanyuJokyo;
    private final Models<JukyushaDaichoIdentifier, JukyushaDaicho> jukyushaDaicho;
    private final Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha;
    private final Models<SeikatsuHogoJukyushaIdentifier, SeikatsuHogoJukyusha> seikatsuHogoJukyusha;

    /**
     * {@link DbT1001HihokenshaDaichoEntity}より{@link HihokenshaDaicho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1001HihokenshaDaichoEntity}
     * @param id {@link HihokenshaDaichoIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    HihokenshaDaichoBuilder(
            DbT1001HihokenshaDaichoEntity entity,
            HihokenshaDaichoIdentifier id,
            Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaisho,
            Models<IryohokenKanyuJokyoIdentifier, IryohokenKanyuJokyo> iryohokenKanyuJokyo,
            Models<JukyushaDaichoIdentifier, JukyushaDaicho> jukyushaDaicho,
            Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha,
            Models<SeikatsuHogoJukyushaIdentifier, SeikatsuHogoJukyusha> seikatsuHogoJukyusha
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.shisetsuNyutaisho = shisetsuNyutaisho;
        this.iryohokenKanyuJokyo = iryohokenKanyuJokyo;
        this.jukyushaDaicho = jukyushaDaicho;
        this.roreiFukushiNenkinJukyusha = roreiFukushiNenkinJukyusha;
        this.seikatsuHogoJukyusha = seikatsuHogoJukyusha;
    }

    /**
     * 異動事由コードを設定します。
     *
     * @param 異動事由コード 異動事由コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set異動事由コード(RString 異動事由コード) {
        requireNonNull(異動事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由コード"));
        entity.setIdoJiyuCode(異動事由コード);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 資格取得事由コードを設定します。
     *
     * @param 資格取得事由コード 資格取得事由コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格取得事由コード(RString 資格取得事由コード) {
        requireNonNull(資格取得事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得事由コード"));
        entity.setShikakuShutokuJiyuCode(資格取得事由コード);
        return this;
    }

    /**
     * 資格取得年月日を設定します。
     *
     * @param 資格取得年月日 資格取得年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格取得年月日(FlexibleDate 資格取得年月日) {
        requireNonNull(資格取得年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得年月日"));
        entity.setShikakuShutokuYMD(資格取得年月日);
        return this;
    }

    /**
     * 資格取得届出年月日を設定します。
     *
     * @param 資格取得届出年月日 資格取得届出年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格取得届出年月日(FlexibleDate 資格取得届出年月日) {
        requireNonNull(資格取得届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得届出年月日"));
        entity.setShikakuShutokuTodokedeYMD(資格取得届出年月日);
        return this;
    }

    /**
     * 第1号資格取得年月日を設定します。
     *
     * @param 第1号資格取得年月日 第1号資格取得年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set第1号資格取得年月日(FlexibleDate 第1号資格取得年月日) {
        requireNonNull(第1号資格取得年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("第1号資格取得年月日"));
        entity.setIchigoShikakuShutokuYMD(第1号資格取得年月日);
        return this;
    }

    /**
     * 被保険者区分コードを設定します。
     *
     * @param 被保険者区分コード 被保険者区分コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set被保険者区分コード(RString 被保険者区分コード) {
        requireNonNull(被保険者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者区分コード"));
        entity.setHihokennshaKubunCode(被保険者区分コード);
        return this;
    }

    /**
     * 資格喪失事由コードを設定します。
     *
     * @param 資格喪失事由コード 資格喪失事由コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格喪失事由コード(RString 資格喪失事由コード) {
        requireNonNull(資格喪失事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失事由コード"));
        entity.setShikakuSoshitsuJiyuCode(資格喪失事由コード);
        return this;
    }

    /**
     * 資格喪失年月日を設定します。
     *
     * @param 資格喪失年月日 資格喪失年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格喪失年月日(FlexibleDate 資格喪失年月日) {
        requireNonNull(資格喪失年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失年月日"));
        entity.setShikakuSoshitsuYMD(資格喪失年月日);
        return this;
    }

    /**
     * 資格喪失届出年月日を設定します。
     *
     * @param 資格喪失届出年月日 資格喪失届出年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格喪失届出年月日(FlexibleDate 資格喪失届出年月日) {
        requireNonNull(資格喪失届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失届出年月日"));
        entity.setShikakuSoshitsuTodokedeYMD(資格喪失届出年月日);
        return this;
    }

    /**
     * 資格変更事由コードを設定します。
     *
     * @param 資格変更事由コード 資格変更事由コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格変更事由コード(RString 資格変更事由コード) {
        requireNonNull(資格変更事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更事由コード"));
        entity.setShikakuHenkoJiyuCode(資格変更事由コード);
        return this;
    }

    /**
     * 資格変更年月日を設定します。
     *
     * @param 資格変更年月日 資格変更年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格変更年月日(FlexibleDate 資格変更年月日) {
        requireNonNull(資格変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更年月日"));
        entity.setShikakuHenkoYMD(資格変更年月日);
        return this;
    }

    /**
     * 資格変更届出年月日を設定します。
     *
     * @param 資格変更届出年月日 資格変更届出年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set資格変更届出年月日(FlexibleDate 資格変更届出年月日) {
        requireNonNull(資格変更届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更届出年月日"));
        entity.setShikakuHenkoTodokedeYMD(資格変更届出年月日);
        return this;
    }

    /**
     * 住所地特例適用事由コードを設定します。
     *
     * @param 住所地特例適用事由コード 住所地特例適用事由コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set住所地特例適用事由コード(RString 住所地特例適用事由コード) {
        requireNonNull(住所地特例適用事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例適用事由コード"));
        entity.setJushochitokureiTekiyoJiyuCode(住所地特例適用事由コード);
        return this;
    }

    /**
     * 適用年月日を設定します。
     *
     * @param 適用年月日 適用年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set適用年月日(FlexibleDate 適用年月日) {
        requireNonNull(適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用年月日"));
        entity.setJushochitokureiTekiyoYMD(適用年月日);
        return this;
    }

    /**
     * 適用届出年月日を設定します。
     *
     * @param 適用届出年月日 適用届出年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set適用届出年月日(FlexibleDate 適用届出年月日) {
        requireNonNull(適用届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用届出年月日"));
        entity.setJushochitokureiTekiyoTodokedeYMD(適用届出年月日);
        return this;
    }

    /**
     * 住所地特例解除事由コードを設定します。
     *
     * @param 住所地特例解除事由コード 住所地特例解除事由コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set住所地特例解除事由コード(RString 住所地特例解除事由コード) {
        requireNonNull(住所地特例解除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例解除事由コード"));
        entity.setJushochitokureiKaijoJiyuCode(住所地特例解除事由コード);
        return this;
    }

    /**
     * 解除年月日を設定します。
     *
     * @param 解除年月日 解除年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set解除年月日(FlexibleDate 解除年月日) {
        requireNonNull(解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除年月日"));
        entity.setJushochitokureiKaijoYMD(解除年月日);
        return this;
    }

    /**
     * 解除届出年月日を設定します。
     *
     * @param 解除届出年月日 解除届出年月日
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set解除届出年月日(FlexibleDate 解除届出年月日) {
        requireNonNull(解除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除届出年月日"));
        entity.setJushochitokureiKaijoTodokedeYMD(解除届出年月日);
        return this;
    }

    /**
     * 住所地特例フラグを設定します。
     *
     * @param 住所地特例フラグ 住所地特例フラグ
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set住所地特例フラグ(RString 住所地特例フラグ) {
        requireNonNull(住所地特例フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例フラグ"));
        entity.setJushochiTokureiFlag(住所地特例フラグ);
        return this;
    }

    /**
     * 広域内住所地特例フラグを設定します。
     *
     * @param 広域内住所地特例フラグ 広域内住所地特例フラグ
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set広域内住所地特例フラグ(RString 広域内住所地特例フラグ) {
        requireNonNull(広域内住所地特例フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内住所地特例フラグ"));
        entity.setKoikinaiJushochiTokureiFlag(広域内住所地特例フラグ);
        return this;
    }

    /**
     * 広住特措置元市町村コードを設定します。
     *
     * @param 広住特措置元市町村コード 広住特措置元市町村コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set広住特措置元市町村コード(LasdecCode 広住特措置元市町村コード) {
        requireNonNull(広住特措置元市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("広住特措置元市町村コード"));
        entity.setKoikinaiTokureiSochimotoShichosonCode(広住特措置元市町村コード);
        return this;
    }

    /**
     * 旧市町村コードを設定します。
     *
     * @param 旧市町村コード 旧市町村コード
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set旧市町村コード(LasdecCode 旧市町村コード) {
        requireNonNull(旧市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード"));
        entity.setKyuShichosonCode(旧市町村コード);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link HihokenshaDaichoBuilder}
     */
    public HihokenshaDaichoBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    // <editor-fold defaultstate="collapsed" desc="子階層のリレーションテーブルのBusinessをメンバー変数で保持する場合">
//TODO 子テーブル１「精神手帳任意項目情報 SeishinTechoNini」を適宜置換して下さい。
    /**
     * 介護保険施設入退所情報のキー情報について判定します。<br>
     * 被保険者台帳管理情報に関連できる介護保険施設入退所情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護保険施設入退所情報リストに介護保険施設入退所情報{@link ShisetsuNyutaisho}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護保険施設入退所情報 {@link ShisetsuNyutaisho}
     * @return {@link HihokenshaDaichoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public HihokenshaDaichoBuilder setShisetsuNyutaisho(ShisetsuNyutaisho 介護保険施設入退所情報) {
        if (hasShisetsuNyutaishoIdentifier(介護保険施設入退所情報.identifier())) {
            shisetsuNyutaisho.add(介護保険施設入退所情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasShisetsuNyutaishoIdentifier(ShisetsuNyutaishoIdentifier 精介護保険施設入退所情報識別子) {
        return (entity.getShikibetsuCode().equals(精介護保険施設入退所情報識別子.get識別コード()));
    }

    /**
     * 介介護保険医療保険加入状況情報のキー情報について判定します。<br>
     * 被保険者台帳管理情報に関連できる介護保険医療保険加入状況情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護保険医療保険加入状況情報リストに介護保険医療保険加入状況情報{@link IryohokenKanyuJokyo}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護保険医療保険加入状況情報 {@link IryohokenKanyuJokyo}
     * @return {@link HihokenshaDaichoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public HihokenshaDaichoBuilder setIryohokenKanyuJokyo(IryohokenKanyuJokyo 介護保険医療保険加入状況情報) {
        if (hasIryohokenKanyuJokyoIdentifier(介護保険医療保険加入状況情報.identifier())) {
            iryohokenKanyuJokyo.add(介護保険医療保険加入状況情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasIryohokenKanyuJokyoIdentifier(IryohokenKanyuJokyoIdentifier 介護保険医療保険加入状況情報識別子) {
        return (entity.getShikibetsuCode().equals(介護保険医療保険加入状況情報識別子.get識別コード()));
    }

    /**
     * 受給者台帳情報のキー情報について判定します。<br>
     * 被保険者台帳管理情報に関連できる受給者台帳情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は受給者台帳情報リストに受給者台帳情報{@link JukyushaDaicho}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 受給者台帳情報 {@link JukyushaDaicho}
     * @return {@link HihokenshaDaichoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public HihokenshaDaichoBuilder setJukyushaDaicho(JukyushaDaicho 受給者台帳情報) {
        if (hasJukyushaDaichoIdentifier(受給者台帳情報.identifier())) {
            jukyushaDaicho.add(受給者台帳情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasJukyushaDaichoIdentifier(JukyushaDaichoIdentifier 受給者台帳情報識別子) {
        return (id.get被保険者番号().equals(受給者台帳情報識別子.get被保険者番号())
                && id.get枝番().equals(受給者台帳情報識別子.get枝番()));
    }

    /**
     * 老齢福祉年金受給者情報のキー情報について判定します。<br>
     * 被保険者台帳管理情報に関連できる老齢福祉年金受給者情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は老齢福祉年金受給者情報リストに老齢福祉年金受給者情報{@link RoreiFukushiNenkinJukyusha}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 老齢福祉年金受給者情報 {@link RoreiFukushiNenkinJukyusha}
     * @return {@link HihokenshaDaichoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public HihokenshaDaichoBuilder setRoreiFukushiNenkinJukyusha(RoreiFukushiNenkinJukyusha 老齢福祉年金受給者情報) {
        if (hasRoreiFukushiNenkinJukyushaIdentifier(老齢福祉年金受給者情報.identifier())) {
            roreiFukushiNenkinJukyusha.add(老齢福祉年金受給者情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasRoreiFukushiNenkinJukyushaIdentifier(RoreiFukushiNenkinJukyushaIdentifier 老齢福祉年金受給者情報識別子) {
        return (entity.getShikibetsuCode().equals(老齢福祉年金受給者情報識別子.get識別コード()));
    }

    /**
     * 生活保護受給者情報のキー情報について判定します。<br>
     * 被保険者台帳管理情報に関連できる生活保護受給者情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は生活保護受給者情報リストに生活保護受給者情報{@link SeikatsuHogoJukyusha}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 生活保護受給者情報 {@link SeikatsuHogoJukyusha}
     * @return Builder
     * @throws IllegalStateException キーが一致しない場合
     */
    public HihokenshaDaichoBuilder setTodokedesha(SeikatsuHogoJukyusha 生活保護受給者情報) {
        if (hasSeikatsuHogoJukyushaIdentifier(生活保護受給者情報.identifier())) {
            seikatsuHogoJukyusha.add(生活保護受給者情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSeikatsuHogoJukyushaIdentifier(SeikatsuHogoJukyushaIdentifier 生活保護受給者情報識別子) {
        return (entity.getShikibetsuCode().equals(生活保護受給者情報識別子.get識別コード()));
    }

    /**
     * {@link HihokenshaDaicho}のインスタンスを生成します。
     *
     * @return {@link HihokenshaDaicho}のインスタンス
     */
    public HihokenshaDaicho build() {
        return new HihokenshaDaicho(
                entity,
                id,
                shisetsuNyutaisho,
                iryohokenKanyuJokyo,
                jukyushaDaicho,
                roreiFukushiNenkinJukyusha,
                seikatsuHogoJukyusha);
    }
}
