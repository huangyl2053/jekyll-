/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItemIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItemIdentifier;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link ShujiiIkenshoJoho}の編集を行うビルダークラスです。
 */
public class ShujiiIkenshoJohoBuilder {

    private final DbT5302ShujiiIkenshoJohoEntity entity;
    private final ShujiiIkenshoJohoIdentifier id;
    private final Models<ShujiiIkenshoKinyuItemIdentifier, ShujiiIkenshoKinyuItem> shujiiIkenshoKinyuItem;
    private final Models<ShujiiIkenshoIkenItemIdentifier, ShujiiIkenshoIkenItem> shujiiIkenshoIkenItem;

    /**
     * {@link DbT5302ShujiiIkenshoJohoEntity}より{@link ShujiiIkenshoJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5302ShujiiIkenshoJohoEntity}
     * @param id {@link ShujiiIkenshoJohoIdentifier}
     * @param shujiiIkenshoKinyuItem {@link Models}
     * @param shujiiIkenshoIkenItem {@link Models}
     *
     */
    ShujiiIkenshoJohoBuilder(
            DbT5302ShujiiIkenshoJohoEntity entity,
            ShujiiIkenshoJohoIdentifier id,
            Models<ShujiiIkenshoKinyuItemIdentifier, ShujiiIkenshoKinyuItem> shujiiIkenshoKinyuItem,
            Models<ShujiiIkenshoIkenItemIdentifier, ShujiiIkenshoIkenItem> shujiiIkenshoIkenItem
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.shujiiIkenshoKinyuItem = shujiiIkenshoKinyuItem;
        this.shujiiIkenshoIkenItem = shujiiIkenshoIkenItem;
    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set厚労省IF識別コード(RString 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 主治医意見書依頼区分を設定します。
     *
     * @param 主治医意見書依頼区分 主治医意見書依頼区分
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set主治医意見書依頼区分(RString 主治医意見書依頼区分) {
        requireNonNull(主治医意見書依頼区分, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書依頼区分"));
        entity.setIkenshoIraiKubun(主治医意見書依頼区分);
        return this;
    }

    /**
     * 主治医医療機関コードを設定します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set主治医医療機関コード(RString 主治医医療機関コード) {
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        entity.setShujiiIryoKikanCode(主治医医療機関コード);
        return this;
    }

    /**
     * 主治医コードを設定します。
     *
     * @param 主治医コード 主治医コード
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set主治医コード(RString 主治医コード) {
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));
        entity.setShujiiCode(主治医コード);
        return this;
    }

    /**
     * 主治医意見書受領年月日を設定します。
     *
     * @param 主治医意見書受領年月日 主治医意見書受領年月日
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set主治医意見書受領年月日(FlexibleDate 主治医意見書受領年月日) {
        requireNonNull(主治医意見書受領年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書受領年月日"));
        entity.setIkenshoJuryoYMD(主治医意見書受領年月日);
        return this;
    }

    /**
     * 主治医意見書記入年月日を設定します。
     *
     * @param 主治医意見書記入年月日 主治医意見書記入年月日
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set主治医意見書記入年月日(FlexibleDate 主治医意見書記入年月日) {
        requireNonNull(主治医意見書記入年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書記入年月日"));
        entity.setIkenshoKinyuYMD(主治医意見書記入年月日);
        return this;
    }

    /**
     * 意見書作成回数区分を設定します。
     *
     * @param 意見書作成回数区分 意見書作成回数区分
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set意見書作成回数区分(Code 意見書作成回数区分) {
        requireNonNull(意見書作成回数区分, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成回数区分"));
        entity.setIkenshoSakuseiKaisuKubun(意見書作成回数区分);
        return this;
    }

    /**
     * 在宅／施設区分を設定します。
     *
     * @param 在宅_施設区分 在宅_施設区分
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set在宅_施設区分(Code 在宅_施設区分) {
        requireNonNull(在宅_施設区分, UrSystemErrorMessages.値がnull.getReplacedMessage("在宅／施設区分"));
        entity.setZaitakuShisetsuKubun(在宅_施設区分);
        return this;
    }

    /**
     * 意見書同意フラグを設定します。
     *
     * @param 意見書同意フラグ 意見書同意フラグ
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set意見書同意フラグ(boolean 意見書同意フラグ) {
        requireNonNull(意見書同意フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書同意フラグ"));
        entity.setIkenshoDoiFlag(意見書同意フラグ);
        return this;
    }

    /**
     * 最終診療日を設定します。
     *
     * @param 最終診療日 最終診療日
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set最終診療日(FlexibleDate 最終診療日) {
        requireNonNull(最終診療日, UrSystemErrorMessages.値がnull.getReplacedMessage("最終診療日"));
        entity.setSaishuShinryoYMD(最終診療日);
        return this;
    }

    /**
     * 他科受診の有無を設定します。
     *
     * @param 他科受診の有無 他科受診の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set他科受診の有無(boolean 他科受診の有無) {
        requireNonNull(他科受診の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("他科受診の有無"));
        entity.setExistTakaJushinFlag(他科受診の有無);
        return this;
    }

    /**
     * 内科受診の有無を設定します。
     *
     * @param 内科受診の有無 内科受診の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set内科受診の有無(boolean 内科受診の有無) {
        requireNonNull(内科受診の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("内科受診の有無"));
        entity.setExistNaikaJushinFlag(内科受診の有無);
        return this;
    }

    /**
     * 精神科受診の有無を設定します。
     *
     * @param 精神科受診の有無 精神科受診の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set精神科受診の有無(boolean 精神科受診の有無) {
        requireNonNull(精神科受診の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("精神科受診の有無"));
        entity.setExistSeishinkaJushinFlag(精神科受診の有無);
        return this;
    }

    /**
     * 外科受診の有無を設定します。
     *
     * @param 外科受診の有無 外科受診の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set外科受診の有無(boolean 外科受診の有無) {
        requireNonNull(外科受診の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("外科受診の有無"));
        entity.setExistGekaJushinFlag(外科受診の有無);
        return this;
    }

    /**
     * 整形外科受診の有無を設定します。
     *
     * @param 整形外科受診の有無 整形外科受診の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set整形外科受診の有無(boolean 整形外科受診の有無) {
        requireNonNull(整形外科受診の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("整形外科受診の有無"));
        entity.setExistSeikeigekaJushinFlag(整形外科受診の有無);
        return this;
    }

    /**
     * 脳神経外科の有無を設定します。
     *
     * @param 脳神経外科の有無 脳神経外科の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set脳神経外科の有無(boolean 脳神経外科の有無) {
        requireNonNull(脳神経外科の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("脳神経外科の有無"));
        entity.setExistNoshinkeigekaJushinFlag(脳神経外科の有無);
        return this;
    }

    /**
     * 皮膚科受診の有無を設定します。
     *
     * @param 皮膚科受診の有無 皮膚科受診の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set皮膚科受診の有無(boolean 皮膚科受診の有無) {
        requireNonNull(皮膚科受診の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("皮膚科受診の有無"));
        entity.setExistHifukaJushinFlag(皮膚科受診の有無);
        return this;
    }

    /**
     * 泌尿器科受診の有無を設定します。
     *
     * @param 泌尿器科受診の有無 泌尿器科受診の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set泌尿器科受診の有無(boolean 泌尿器科受診の有無) {
        requireNonNull(泌尿器科受診の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("泌尿器科受診の有無"));
        entity.setExistHinyokikaJushinFlag(泌尿器科受診の有無);
        return this;
    }

    /**
     * 婦人科受診の有無を設定します。
     *
     * @param 婦人科受診の有無 婦人科受診の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set婦人科受診の有無(boolean 婦人科受診の有無) {
        requireNonNull(婦人科受診の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("婦人科受診の有無"));
        entity.setExistFujinkaJushinFlag(婦人科受診の有無);
        return this;
    }

    /**
     * 耳鼻咽喉科受診の有無を設定します。
     *
     * @param 耳鼻咽喉科受診の有無 耳鼻咽喉科受診の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set耳鼻咽喉科受診の有無(boolean 耳鼻咽喉科受診の有無) {
        requireNonNull(耳鼻咽喉科受診の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("耳鼻咽喉科受診の有無"));
        entity.setExistJibiinkokaJushinFlag(耳鼻咽喉科受診の有無);
        return this;
    }

    /**
     * リハビリテーション科受診の有無を設定します。
     *
     * @param リハビリテーション科受診の有無 リハビリテーション科受診の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder setリハビリテーション科受診の有無(boolean リハビリテーション科受診の有無) {
        requireNonNull(リハビリテーション科受診の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション科受診の有無"));
        entity.setExistRehabilitationkaJushinFlag(リハビリテーション科受診の有無);
        return this;
    }

    /**
     * 歯科受診の有無を設定します。
     *
     * @param 歯科受診の有無 歯科受診の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set歯科受診の有無(boolean 歯科受診の有無) {
        requireNonNull(歯科受診の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("歯科受診の有無"));
        entity.setExistShikaJushinFlag(歯科受診の有無);
        return this;
    }

    /**
     * 眼科の有無を設定します。
     *
     * @param 眼科の有無 眼科の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set眼科の有無(boolean 眼科の有無) {
        requireNonNull(眼科の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("眼科の有無"));
        entity.setExistGankaJushinFlag(眼科の有無);
        return this;
    }

    /**
     * その他受診科の有無を設定します。
     *
     * @param その他受診科の有無 その他受診科の有無
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder setその他受診科の有無(boolean その他受診科の有無) {
        requireNonNull(その他受診科の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("その他受診科の有無"));
        entity.setExistSonotaJushinkaFlag(その他受診科の有無);
        return this;
    }

    /**
     * その他受診科名を設定します。
     *
     * @param その他受診科名 その他受診科名
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder setその他受診科名(RString その他受診科名) {
        requireNonNull(その他受診科名, UrSystemErrorMessages.値がnull.getReplacedMessage("その他受診科名"));
        entity.setSonotaJushinKaShimei(その他受診科名);
        return this;
    }

    /**
     * 意見書・診断名1を設定します。
     *
     * @param 意見書_診断名1 意見書_診断名1
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set意見書_診断名1(RString 意見書_診断名1) {
        requireNonNull(意見書_診断名1, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書・診断名1"));
        entity.setShindamMei1(意見書_診断名1);
        return this;
    }

    /**
     * 意見書・発症年月日1を設定します。
     *
     * @param 意見書_発症年月日1 意見書_発症年月日1
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set意見書_発症年月日1(FlexibleDate 意見書_発症年月日1) {
        requireNonNull(意見書_発症年月日1, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書・発症年月日1"));
        entity.setHasshoYMD1(意見書_発症年月日1);
        return this;
    }

    /**
     * 意見書・診断名2を設定します。
     *
     * @param 意見書_診断名2 意見書_診断名2
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set意見書_診断名2(RString 意見書_診断名2) {
        requireNonNull(意見書_診断名2, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書・診断名2"));
        entity.setShindamMei2(意見書_診断名2);
        return this;
    }

    /**
     * 意見書・発症年月日2を設定します。
     *
     * @param 意見書_発症年月日2 意見書_発症年月日2
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set意見書_発症年月日2(FlexibleDate 意見書_発症年月日2) {
        requireNonNull(意見書_発症年月日2, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書・発症年月日2"));
        entity.setHasshoYMD2(意見書_発症年月日2);
        return this;
    }

    /**
     * 意見書・診断名3を設定します。
     *
     * @param 意見書_診断名3 意見書_診断名3
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set意見書_診断名3(RString 意見書_診断名3) {
        requireNonNull(意見書_診断名3, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書・診断名3"));
        entity.setShindamMei3(意見書_診断名3);
        return this;
    }

    /**
     * 意見書・発症年月日3を設定します。
     *
     * @param 意見書_発症年月日3 意見書_発症年月日3
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set意見書_発症年月日3(FlexibleDate 意見書_発症年月日3) {
        requireNonNull(意見書_発症年月日3, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書・発症年月日3"));
        entity.setHasshoYMD3(意見書_発症年月日3);
        return this;
    }

    /**
     * 意見書・症状としての安定性を設定します。
     *
     * @param 意見書_症状としての安定性 意見書_症状としての安定性
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set意見書_症状としての安定性(RString 意見書_症状としての安定性) {
        requireNonNull(意見書_症状としての安定性, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書・症状としての安定性"));
        entity.setAnteisei(意見書_症状としての安定性);
        return this;
    }

    /**
     * 意見書・症状としての安定性　不安定状況を設定します。
     *
     * @param 意見書_症状としての安定性_不安定状況 意見書_症状としての安定性_不安定状況
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set意見書_症状としての安定性_不安定状況(RString 意見書_症状としての安定性_不安定状況) {
        requireNonNull(意見書_症状としての安定性_不安定状況, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書・症状としての安定性　不安定状況"));
        entity.setFuanteiJokyo(意見書_症状としての安定性_不安定状況);
        return this;
    }

    /**
     * 治療内容を設定します。
     *
     * @param 治療内容 治療内容
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set治療内容(RString 治療内容) {
        requireNonNull(治療内容, UrSystemErrorMessages.値がnull.getReplacedMessage("治療内容"));
        entity.setChiryoNaiyo(治療内容);
        return this;
    }

    /**
     * 特記事項を設定します。
     *
     * @param 特記事項 特記事項
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set特記事項(RString 特記事項) {
        requireNonNull(特記事項, UrSystemErrorMessages.値がnull.getReplacedMessage("特記事項"));
        entity.setTokkiJiko(特記事項);
        return this;
    }

    /**
     * 特記事項イメージ共有ファイルIDを設定します。
     *
     * @param 特記事項イメージ共有ファイルID 特記事項イメージ共有ファイルID
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set特記事項イメージ共有ファイルID(RDateTime 特記事項イメージ共有ファイルID) {
        requireNonNull(特記事項イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("特記事項イメージ共有ファイルID"));
        entity.setTokkiJikoImageSharedFileId(特記事項イメージ共有ファイルID);
        return this;
    }

    /**
     * 認定審査会後の二次判定結果の連絡確認フラグを設定します。
     *
     * @param 認定審査会後の二次判定結果の連絡確認フラグ 認定審査会後の二次判定結果の連絡確認フラグ
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set認定審査会後の二次判定結果の連絡確認フラグ(boolean 認定審査会後の二次判定結果の連絡確認フラグ) {
        requireNonNull(認定審査会後の二次判定結果の連絡確認フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("認定審査会後の二次判定結果の連絡確認フラグ"));
        entity.setNijiHanteiKekkaRenrakuFlag(認定審査会後の二次判定結果の連絡確認フラグ);
        return this;
    }

    /**
     * 意見書メモを設定します。
     *
     * @param 意見書メモ 意見書メモ
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder set意見書メモ(RString 意見書メモ) {
        requireNonNull(意見書メモ, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書メモ"));
        entity.setIkenshoMemo(意見書メモ);
        return this;
    }

    /**
     * 要介護認定主治医意見書記入項目について判定します。<br>
     * 要介護認定主治医意見書情報に関連できる要介護認定主治医意見書記入項目である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は要介護認定主治医意見書記入項目情報リストに要介護認定主治医意見書記入項目{@link ShujiiIkenshoKinyuItem}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 要介護認定主治医意見書記入項目 {@link ShujiiIkenshoKinyuItem}
     * @return {@link ShujiiIkenshoJohoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShujiiIkenshoJohoBuilder setShujiiIkenshoKinyuItem(ShujiiIkenshoKinyuItem 要介護認定主治医意見書記入項目) {
        if (hasSameIdentifier(要介護認定主治医意見書記入項目.identifier())) {
            shujiiIkenshoKinyuItem.add(要介護認定主治医意見書記入項目);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ShujiiIkenshoKinyuItemIdentifier 要介護認定主治医意見書記入項目の識別子) {
        return (id.get申請書管理番号().equals(要介護認定主治医意見書記入項目の識別子.get申請書管理番号())
                && id.get主治医意見書作成依頼履歴番号() == 要介護認定主治医意見書記入項目の識別子.get主治医意見書作成依頼履歴番号());
    }

    /**
     * 要介護認定主治医意見書意見項目について判定します。<br>
     * 要介護認定主治医意見書情報に関連できる要介護認定主治医意見書意見項目である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は要介護認定主治医意見書意見項目リストに要介護認定主治医意見書意見項目{@link ShujiiIkenshoIkenItem}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 要介護認定主治医意見書意見項目 {@link ShujiiIkenshoIkenItem}
     * @return ShujiiIkenshoJohoBuilder
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShujiiIkenshoJohoBuilder setShujiiIkenshoIkenItem(ShujiiIkenshoIkenItem 要介護認定主治医意見書意見項目) {
        if (hasSameIdentifier1(要介護認定主治医意見書意見項目.identifier())) {
            shujiiIkenshoIkenItem.add(要介護認定主治医意見書意見項目);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier1(ShujiiIkenshoIkenItemIdentifier 要介護認定主治医意見書意見項目の識別子) {
        return (id.get申請書管理番号().equals(要介護認定主治医意見書意見項目の識別子.get申請書管理番号())
                && id.get主治医意見書作成依頼履歴番号() == 要介護認定主治医意見書意見項目の識別子.get主治医意見書作成依頼履歴番号());
    }

    /**
     * {@link ShujiiIkenshoJoho}のインスタンスを生成します。
     *
     * @return {@link ShujiiIkenshoJoho}のインスタンス
     */
    public ShujiiIkenshoJoho build() {
        return new ShujiiIkenshoJoho(entity, id, shujiiIkenshoKinyuItem, shujiiIkenshoIkenItem);
    }
}
