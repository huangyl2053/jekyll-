/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link JuryoininKeiyakuJigyosha}の編集を行うビルダークラスです。
 */
public class JuryoininKeiyakuJigyoshaBuilder {

    private final DbT3077JuryoininKeiyakuJigyoshaEntity entity;
    private final JuryoininKeiyakuJigyoshaIdentifier id;

    /**
     * {@link DbT3077JuryoininKeiyakuJigyoshaEntity}より{@link JuryoininKeiyakuJigyosha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3077JuryoininKeiyakuJigyoshaEntity}
     * @param id {@link JuryoininKeiyakuJigyoshaIdentifier}
     *
     */
    JuryoininKeiyakuJigyoshaBuilder(
            DbT3077JuryoininKeiyakuJigyoshaEntity entity,
            JuryoininKeiyakuJigyoshaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 事業者契約番号を設定します。
     *
     * @param 事業者契約番号 事業者契約番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set事業者契約番号(RString 事業者契約番号) {
        requireNonNull(事業者契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者契約番号"));
        entity.setJigyoshaKeiyakuNo(事業者契約番号);
        return this;
    }

    /**
     * 開始年月日を設定します。
     *
     * @param 開始年月日 開始年月日
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set開始年月日(FlexibleDate 開始年月日) {
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        entity.setKaishiYMD(開始年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 終了年月日を設定します。
     *
     * @param 終了年月日 終了年月日
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set終了年月日(FlexibleDate 終了年月日) {
        requireNonNull(終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月日"));
        entity.setShuryoYMD(終了年月日);
        return this;
    }

    /**
     * 届出年月日を設定します。
     *
     * @param 届出年月日 届出年月日
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set届出年月日(FlexibleDate 届出年月日) {
        requireNonNull(届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("届出年月日"));
        entity.setTodokedeYMD(届出年月日);
        return this;
    }

    /**
     * 届出者住所を設定します。
     *
     * @param 届出者住所 届出者住所
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set届出者住所(RString 届出者住所) {
        requireNonNull(届出者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者住所"));
        entity.setTodokedeAddress(届出者住所);
        return this;
    }

    /**
     * 届出者事業者名称を設定します。
     *
     * @param 届出者事業者名称 届出者事業者名称
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set届出者事業者名称(RString 届出者事業者名称) {
        requireNonNull(届出者事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者事業者名称"));
        entity.setTodokedeJigyoshaName(届出者事業者名称);
        return this;
    }

    /**
     * 届出者代表者氏名を設定します。
     *
     * @param 届出者代表者氏名 届出者代表者氏名
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set届出者代表者氏名(RString 届出者代表者氏名) {
        requireNonNull(届出者代表者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("届出者代表者氏名"));
        entity.setTodokedeDaihyoshaName(届出者代表者氏名);
        return this;
    }

    /**
     * 金融機関コードを設定します。
     *
     * @param 金融機関コード 金融機関コード
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set金融機関コード(KinyuKikanCode 金融機関コード) {
        requireNonNull(金融機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("金融機関コード"));
        entity.setKinyuKikanCode(金融機関コード);
        return this;
    }

    /**
     * 支店コードを設定します。
     *
     * @param 支店コード 支店コード
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set支店コード(KinyuKikanShitenCode 支店コード) {
        requireNonNull(支店コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支店コード"));
        entity.setShitenCode(支店コード);
        return this;
    }

    /**
     * 口座種別を設定します。
     *
     * @param 口座種別 口座種別
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set口座種別(RString 口座種別) {
        requireNonNull(口座種別, UrSystemErrorMessages.値がnull.getReplacedMessage("口座種別"));
        entity.setKozaShubetsu(口座種別);
        return this;
    }

    /**
     * 口座番号を設定します。
     *
     * @param 口座番号 口座番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set口座番号(RString 口座番号) {
        requireNonNull(口座番号, UrSystemErrorMessages.値がnull.getReplacedMessage("口座番号"));
        entity.setKozaNo(口座番号);
        return this;
    }

    /**
     * 通帳記号を設定します。
     *
     * @param 通帳記号 通帳記号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set通帳記号(RString 通帳記号) {
        requireNonNull(通帳記号, UrSystemErrorMessages.値がnull.getReplacedMessage("通帳記号"));
        entity.setTsuchoKigo(通帳記号);
        return this;
    }

    /**
     * 通帳番号を設定します。
     *
     * @param 通帳番号 通帳番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set通帳番号(RString 通帳番号) {
        requireNonNull(通帳番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通帳番号"));
        entity.setTsuchoNo(通帳番号);
        return this;
    }

    /**
     * 口座名義人を設定します。
     *
     * @param 口座名義人 口座名義人
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set口座名義人(AtenaKanaMeisho 口座名義人) {
        requireNonNull(口座名義人, UrSystemErrorMessages.値がnull.getReplacedMessage("口座名義人"));
        entity.setKozaMeiginin(口座名義人);
        return this;
    }

    /**
     * 口座名義人漢字を設定します。
     *
     * @param 口座名義人漢字 口座名義人漢字
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set口座名義人漢字(AtenaMeisho 口座名義人漢字) {
        requireNonNull(口座名義人漢字, UrSystemErrorMessages.値がnull.getReplacedMessage("口座名義人漢字"));
        entity.setKozaMeigininKanji(口座名義人漢字);
        return this;
    }

    /**
     * 事業者FAX番号を設定します。
     *
     * @param 事業者FAX番号 事業者FAX番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set事業者FAX番号(TelNo 事業者FAX番号) {
        requireNonNull(事業者FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者FAX番号"));
        entity.setJigyoshaFaxNo(事業者FAX番号);
        return this;
    }

    /**
     * 契約登録年月日を設定します。
     *
     * @param 契約登録年月日 契約登録年月日
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約登録年月日(FlexibleDate 契約登録年月日) {
        requireNonNull(契約登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("契約登録年月日"));
        entity.setKeiyakuTorokuYMD(契約登録年月日);
        return this;
    }

    /**
     * 送付先部署を設定します。
     *
     * @param 送付先部署 送付先部署
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set送付先部署(RString 送付先部署) {
        requireNonNull(送付先部署, UrSystemErrorMessages.値がnull.getReplacedMessage("送付先部署"));
        entity.setSofusakiBusho(送付先部署);
        return this;
    }

    /**
     * 営業形態を設定します。
     *
     * @param 営業形態 営業形態
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set営業形態(RString 営業形態) {
        requireNonNull(営業形態, UrSystemErrorMessages.値がnull.getReplacedMessage("営業形態"));
        entity.setEigyoKeitai(営業形態);
        return this;
    }

    /**
     * 住宅改修契約有無を設定します。
     *
     * @param 住宅改修契約有無 住宅改修契約有無
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set住宅改修契約有無(boolean 住宅改修契約有無) {
        requireNonNull(住宅改修契約有無, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修契約有無"));
        entity.setJutakuKaishuKeiyakuUmu(住宅改修契約有無);
        return this;
    }

    /**
     * 特定福祉用具販売契約有無を設定します。
     *
     * @param 特定福祉用具販売契約有無 特定福祉用具販売契約有無
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set特定福祉用具販売契約有無(boolean 特定福祉用具販売契約有無) {
        requireNonNull(特定福祉用具販売契約有無, UrSystemErrorMessages.値がnull.getReplacedMessage("特定福祉用具販売契約有無"));
        entity.setTokuteiFukushiYoguHanbaiKeiyakuUmu(特定福祉用具販売契約有無);
        return this;
    }

    /**
     * 償還払給付契約有無を設定します。
     *
     * @param 償還払給付契約有無 償還払給付契約有無
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set償還払給付契約有無(boolean 償還払給付契約有無) {
        requireNonNull(償還払給付契約有無, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払給付契約有無"));
        entity.setShokanbaraiKyufuKeiyakuUmu(償還払給付契約有無);
        return this;
    }

    /**
     * 高額給付契約有無を設定します。
     *
     * @param 高額給付契約有無 高額給付契約有無
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set高額給付契約有無(boolean 高額給付契約有無) {
        requireNonNull(高額給付契約有無, UrSystemErrorMessages.値がnull.getReplacedMessage("高額給付契約有無"));
        entity.setKogakuKyufuKeiyakuUmu(高額給付契約有無);
        return this;
    }

    /**
     * 契約事業者番号を設定します。
     *
     * @param 契約事業者番号 契約事業者番号
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set契約事業者番号(JigyoshaNo 契約事業者番号) {
        requireNonNull(契約事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者番号"));
        entity.setKeiyakuJigyoshaNo(契約事業者番号);
        return this;
    }

    /**
     * 取扱確約書有無を設定します。
     *
     * @param 取扱確約書有無 取扱確約書有無
     * @return {@link JuryoininKeiyakuJigyoshaBuilder}
     */
    public JuryoininKeiyakuJigyoshaBuilder set取扱確約書有無(boolean 取扱確約書有無) {
        requireNonNull(取扱確約書有無, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱確約書有無"));
        entity.setToriatsukaiKakuyakushoUmu(取扱確約書有無);
        return this;
    }

    /**
     * {@link JuryoininKeiyakuJigyosha}のインスタンスを生成します。
     *
     * @return {@link JuryoininKeiyakuJigyosha}のインスタンス
     */
    public JuryoininKeiyakuJigyosha build() {
        return new JuryoininKeiyakuJigyosha(entity, id);
    }
}
