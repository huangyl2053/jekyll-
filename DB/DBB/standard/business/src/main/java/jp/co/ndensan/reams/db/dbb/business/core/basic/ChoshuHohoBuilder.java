/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHohoIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ChoshuHoho}の編集を行うビルダークラスです。
 */
public class ChoshuHohoBuilder {

    private final DbT2001ChoshuHohoEntity entity;
    private final ChoshuHohoIdentifier id;

    /**
     * {@link DbT2001ChoshuHohoEntity}より{@link ChoshuHoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2001ChoshuHohoEntity}
     * @param id {@link ChoshuHohoIdentifier}
     *
     */
    ChoshuHohoBuilder(
            DbT2001ChoshuHohoEntity entity,
            ChoshuHohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set賦課年度(FlexibleYear 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 徴収方法4月を設定します。
     *
     * @param 徴収方法4月 徴収方法4月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法4月(RString 徴収方法4月) {
        entity.setChoshuHoho4gatsu(徴収方法4月);
        return this;
    }

    /**
     * 徴収方法5月を設定します。
     *
     * @param 徴収方法5月 徴収方法5月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法5月(RString 徴収方法5月) {
        entity.setChoshuHoho5gatsu(徴収方法5月);
        return this;
    }

    /**
     * 徴収方法6月を設定します。
     *
     * @param 徴収方法6月 徴収方法6月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法6月(RString 徴収方法6月) {
        entity.setChoshuHoho6gatsu(徴収方法6月);
        return this;
    }

    /**
     * 徴収方法7月を設定します。
     *
     * @param 徴収方法7月 徴収方法7月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法7月(RString 徴収方法7月) {
        entity.setChoshuHoho7gatsu(徴収方法7月);
        return this;
    }

    /**
     * 徴収方法8月を設定します。
     *
     * @param 徴収方法8月 徴収方法8月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法8月(RString 徴収方法8月) {
        entity.setChoshuHoho8gatsu(徴収方法8月);
        return this;
    }

    /**
     * 徴収方法9月を設定します。
     *
     * @param 徴収方法9月 徴収方法9月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法9月(RString 徴収方法9月) {
        entity.setChoshuHoho9gatsu(徴収方法9月);
        return this;
    }

    /**
     * 徴収方法10月を設定します。
     *
     * @param 徴収方法10月 徴収方法10月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法10月(RString 徴収方法10月) {
        entity.setChoshuHoho10gatsu(徴収方法10月);
        return this;
    }

    /**
     * 徴収方法11月を設定します。
     *
     * @param 徴収方法11月 徴収方法11月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法11月(RString 徴収方法11月) {
        entity.setChoshuHoho11gatsu(徴収方法11月);
        return this;
    }

    /**
     * 徴収方法12月を設定します。
     *
     * @param 徴収方法12月 徴収方法12月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法12月(RString 徴収方法12月) {
        entity.setChoshuHoho12gatsu(徴収方法12月);
        return this;
    }

    /**
     * 徴収方法1月を設定します。
     *
     * @param 徴収方法1月 徴収方法1月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法1月(RString 徴収方法1月) {
        entity.setChoshuHoho1gatsu(徴収方法1月);
        return this;
    }

    /**
     * 徴収方法2月を設定します。
     *
     * @param 徴収方法2月 徴収方法2月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法2月(RString 徴収方法2月) {
        entity.setChoshuHoho2gatsu(徴収方法2月);
        return this;
    }

    /**
     * 徴収方法3月を設定します。
     *
     * @param 徴収方法3月 徴収方法3月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法3月(RString 徴収方法3月) {
        entity.setChoshuHoho3gatsu(徴収方法3月);
        return this;
    }

    /**
     * 徴収方法翌4月を設定します。
     *
     * @param 徴収方法翌4月 徴収方法翌4月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法翌4月(RString 徴収方法翌4月) {
        entity.setChoshuHohoYoku4gatsu(徴収方法翌4月);
        return this;
    }

    /**
     * 徴収方法翌5月を設定します。
     *
     * @param 徴収方法翌5月 徴収方法翌5月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法翌5月(RString 徴収方法翌5月) {
        entity.setChoshuHohoYoku5gatsu(徴収方法翌5月);
        return this;
    }

    /**
     * 徴収方法翌6月を設定します。
     *
     * @param 徴収方法翌6月 徴収方法翌6月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法翌6月(RString 徴収方法翌6月) {
        entity.setChoshuHohoYoku6gatsu(徴収方法翌6月);
        return this;
    }

    /**
     * 徴収方法翌7月を設定します。
     *
     * @param 徴収方法翌7月 徴収方法翌7月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法翌7月(RString 徴収方法翌7月) {
        entity.setChoshuHohoYoku7gatsu(徴収方法翌7月);
        return this;
    }

    /**
     * 徴収方法翌8月を設定します。
     *
     * @param 徴収方法翌8月 徴収方法翌8月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法翌8月(RString 徴収方法翌8月) {
        entity.setChoshuHohoYoku8gatsu(徴収方法翌8月);
        return this;
    }

    /**
     * 徴収方法翌9月を設定します。
     *
     * @param 徴収方法翌9月 徴収方法翌9月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set徴収方法翌9月(RString 徴収方法翌9月) {
        entity.setChoshuHohoYoku9gatsu(徴収方法翌9月);
        return this;
    }

    /**
     * 仮徴収・基礎年金番号を設定します。
     *
     * @param 仮徴収_基礎年金番号 仮徴収・基礎年金番号
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set仮徴収_基礎年金番号(RString 仮徴収_基礎年金番号) {
        entity.setKariNenkinNo(仮徴収_基礎年金番号);
        return this;
    }

    /**
     * 仮徴収・年金コードを設定します。
     *
     * @param 仮徴収_年金コード 仮徴収・年金コード
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set仮徴収_年金コード(RString 仮徴収_年金コード) {
        entity.setKariNenkinCode(仮徴収_年金コード);
        return this;
    }

    /**
     * 仮徴収・捕捉月を設定します。
     *
     * @param 仮徴収_捕捉月 仮徴収・捕捉月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set仮徴収_捕捉月(RString 仮徴収_捕捉月) {
        entity.setKariHosokuM(仮徴収_捕捉月);
        return this;
    }

    /**
     * 本徴収・基礎年金番号を設定します。
     *
     * @param 本徴収_基礎年金番号 本徴収・基礎年金番号
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set本徴収_基礎年金番号(RString 本徴収_基礎年金番号) {
        entity.setHonNenkinNo(本徴収_基礎年金番号);
        return this;
    }

    /**
     * 本徴収・年金コードを設定します。
     *
     * @param 本徴収_年金コード 本徴収・年金コード
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set本徴収_年金コード(RString 本徴収_年金コード) {
        entity.setHonNenkinCode(本徴収_年金コード);
        return this;
    }

    /**
     * 本徴収・捕捉月を設定します。
     *
     * @param 本徴収_捕捉月 本徴収・捕捉月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set本徴収_捕捉月(RString 本徴収_捕捉月) {
        entity.setHonHosokuM(本徴収_捕捉月);
        return this;
    }

    /**
     * 翌年度仮徴収・基礎年金番号を設定します。
     *
     * @param 翌年度仮徴収_基礎年金番号 翌年度仮徴収・基礎年金番号
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set翌年度仮徴収_基礎年金番号(RString 翌年度仮徴収_基礎年金番号) {
        entity.setYokunendoKariNenkinNo(翌年度仮徴収_基礎年金番号);
        return this;
    }

    /**
     * 翌年度仮徴収・年金コードを設定します。
     *
     * @param 翌年度仮徴収_年金コード 翌年度仮徴収・年金コード
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set翌年度仮徴収_年金コード(RString 翌年度仮徴収_年金コード) {
        entity.setYokunendoKariNenkinCode(翌年度仮徴収_年金コード);
        return this;
    }

    /**
     * 翌年度仮徴収・捕捉月を設定します。
     *
     * @param 翌年度仮徴収_捕捉月 翌年度仮徴収・捕捉月
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set翌年度仮徴収_捕捉月(RString 翌年度仮徴収_捕捉月) {
        entity.setYokunendoKariHosokuM(翌年度仮徴収_捕捉月);
        return this;
    }

    /**
     * 依頼情報送付済みフラグを設定します。
     *
     * @param 依頼情報送付済みフラグ 依頼情報送付済みフラグ
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set依頼情報送付済みフラグ(boolean 依頼情報送付済みフラグ) {
        entity.setIraiSohuzumiFlag(依頼情報送付済みフラグ);
        return this;
    }

    /**
     * 追加依頼情報送付済みフラグを設定します。
     *
     * @param 追加依頼情報送付済みフラグ 追加依頼情報送付済みフラグ
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set追加依頼情報送付済みフラグ(boolean 追加依頼情報送付済みフラグ) {
        entity.setTsuikaIraiSohuzumiFlag(追加依頼情報送付済みフラグ);
        return this;
    }

    /**
     * 特別徴収停止日時を設定します。
     *
     * @param 特別徴収停止日時 特別徴収停止日時
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set特別徴収停止日時(YMDHMS 特別徴収停止日時) {
        entity.setTokuchoTeishiNichiji(特別徴収停止日時);
        return this;
    }

    /**
     * 特別徴収停止事由コードを設定します。
     *
     * @param 特別徴収停止事由コード 特別徴収停止事由コード
     * @return {@link ChoshuHohoBuilder}
     */
    public ChoshuHohoBuilder set特別徴収停止事由コード(RString 特別徴収停止事由コード) {
        entity.setTokuchoTeishiJiyuCode(特別徴収停止事由コード);
        return this;
    }

    /**
     * {@link ChoshuHoho}のインスタンスを生成します。
     *
     * @return {@link ChoshuHoho}のインスタンス
     */
    public ChoshuHoho build() {
        return new ChoshuHoho(entity, id);
    }
}
