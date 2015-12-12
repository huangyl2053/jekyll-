/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaijoho.ninteichosairaijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link NinteichosaIraiJoho}の編集を行うビルダークラスです。
 */
public class NinteichosaIraiJohoBuilder {

    private final DbT5201NinteichosaIraiJohoEntity entity;
    private final NinteichosaIraiJohoIdentifier id;

    /**
     * {@link DbT5201NinteichosaIraiJohoEntity}より{@link NinteichosaIraiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5201NinteichosaIraiJohoEntity}
     * @param id {@link NinteichosaIraiJohoIdentifier}
     *
     */
    NinteichosaIraiJohoBuilder(
            DbT5201NinteichosaIraiJohoEntity entity,
            NinteichosaIraiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 認定調査委託先コードを設定します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set認定調査委託先コード(JigyoshaNo 認定調査委託先コード) {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        entity.setNinteichosaItakusakiCode(認定調査委託先コード);
        return this;
    }

    /**
     * 認定調査員コードを設定します。
     *
     * @param 認定調査員コード 認定調査員コード
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set認定調査員コード(RString 認定調査員コード) {
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        entity.setNinteiChosainCode(認定調査員コード);
        return this;
    }

    /**
     * 認定調査依頼区分コードを設定します。
     *
     * @param 認定調査依頼区分コード 認定調査依頼区分コード
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set認定調査依頼区分コード(Code 認定調査依頼区分コード) {
        requireNonNull(認定調査依頼区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼区分コード"));
        entity.setNinteichosaIraiKubunCode(認定調査依頼区分コード);
        return this;
    }

    /**
     * 認定調査回数を設定します。
     *
     * @param 認定調査回数 認定調査回数
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set認定調査回数(int 認定調査回数) {
        requireNonNull(認定調査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査回数"));
        entity.setNinteichosaIraiKaisu(認定調査回数);
        return this;
    }

    /**
     * 認定調査依頼年月日を設定します。
     *
     * @param 認定調査依頼年月日 認定調査依頼年月日
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set認定調査依頼年月日(FlexibleDate 認定調査依頼年月日) {
        requireNonNull(認定調査依頼年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼年月日"));
        entity.setNinteichosaIraiYMD(認定調査依頼年月日);
        return this;
    }

    /**
     * 認定調査期限年月日を設定します。
     *
     * @param 認定調査期限年月日 認定調査期限年月日
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set認定調査期限年月日(FlexibleDate 認定調査期限年月日) {
        requireNonNull(認定調査期限年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査期限年月日"));
        entity.setNinteichosaKigenYMD(認定調査期限年月日);
        return this;
    }

    /**
     * 依頼書出力年月日を設定します。
     *
     * @param 依頼書出力年月日 依頼書出力年月日
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set依頼書出力年月日(FlexibleDate 依頼書出力年月日) {
        requireNonNull(依頼書出力年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("依頼書出力年月日"));
        entity.setIraishoShutsuryokuYMD(依頼書出力年月日);
        return this;
    }

    /**
     * 調査票等出力年月日を設定します。
     *
     * @param 調査票等出力年月日 調査票等出力年月日
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set調査票等出力年月日(FlexibleDate 調査票等出力年月日) {
        requireNonNull(調査票等出力年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("調査票等出力年月日"));
        entity.setChosahyoTouShutsuryokuYMD(調査票等出力年月日);
        return this;
    }

    /**
     * モバイルデータ出力済フラグを設定します。
     *
     * @param モバイルデータ出力済フラグ モバイルデータ出力済フラグ
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder setモバイルデータ出力済フラグ(boolean モバイルデータ出力済フラグ) {
        requireNonNull(モバイルデータ出力済フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("モバイルデータ出力済フラグ"));
        entity.setMobileDataShutsuryokuZumiFlag(モバイルデータ出力済フラグ);
        return this;
    }

    /**
     * 事前調査フラグを設定します。
     *
     * @param 事前調査フラグ 事前調査フラグ
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set事前調査フラグ(boolean 事前調査フラグ) {
        requireNonNull(事前調査フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("事前調査フラグ"));
        entity.setJizenChosaFlag(事前調査フラグ);
        return this;
    }

    /**
     * 認定調査督促年月日を設定します。
     *
     * @param 認定調査督促年月日 認定調査督促年月日
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set認定調査督促年月日(FlexibleDate 認定調査督促年月日) {
        requireNonNull(認定調査督促年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査督促年月日"));
        entity.setNinteichosaTokusokuYMD(認定調査督促年月日);
        return this;
    }

    /**
     * 認定調査督促方法を設定します。
     *
     * @param 認定調査督促方法 認定調査督促方法
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set認定調査督促方法(RString 認定調査督促方法) {
        requireNonNull(認定調査督促方法, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査督促方法"));
        entity.setNinteichosaTokusokuHoho(認定調査督促方法);
        return this;
    }

    /**
     * 認定調査督促回数を設定します。
     *
     * @param 認定調査督促回数 認定調査督促回数
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set認定調査督促回数(int 認定調査督促回数) {
        requireNonNull(認定調査督促回数, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査督促回数"));
        entity.setNinteichosaTokusokuKaisu(認定調査督促回数);
        return this;
    }

    /**
     * 認定調査督促メモを設定します。
     *
     * @param 認定調査督促メモ 認定調査督促メモ
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set認定調査督促メモ(RString 認定調査督促メモ) {
        requireNonNull(認定調査督促メモ, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査督促メモ"));
        entity.setNinteichosaTokusokuMemo(認定調査督促メモ);
        return this;
    }

    /**
     * 論理削除フラグを設定します。
     *
     * @param 論理削除フラグ 論理削除フラグ
     * @return {@link NinteichosaIraiJohoBuilder}
     */
    public NinteichosaIraiJohoBuilder set論理削除フラグ(boolean 論理削除フラグ) {
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return this;
    }

    /**
     * {@link NinteichosaIraiJoho}のインスタンスを生成します。
     *
     * @return {@link NinteichosaIraiJoho}のインスタンス
     */
    public NinteichosaIraiJoho build() {
        return new NinteichosaIraiJoho(entity, id);
    }
}
