/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.fuka;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.ChoshuHoho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.code.kyotsu.TokubetsuChoshuTeishiJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護徴収方法のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class ChoshuHohoModel implements Serializable {

    private DbT2001ChoshuHohoEntity entity;

    /**
     * コンストラクタです。
     */
    public ChoshuHohoModel() {
        entity = new DbT2001ChoshuHohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT2001ChoshuHohoEntity
     */
    public ChoshuHohoModel(DbT2001ChoshuHohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT2001ChoshuHohoEntityを返します。
     *
     * @return DbT2001ChoshuHohoEntity
     */
    public DbT2001ChoshuHohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT2001ChoshuHohoEntityを設定します。
     *
     * @param entity DbT2001ChoshuHohoEntity
     */
    public void setEntity(DbT2001ChoshuHohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FukaNendo get賦課年度() {
        return new FukaNendo(entity.getFukaNendo());
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 徴収方法4月を返します。
     *
     * @return 徴収方法4月
     */
    public ChoshuHoho get徴収方法4月() {
        return ChoshuHoho.toValue(entity.getChoshuHoho4gatsu());
    }

    /**
     * 徴収方法5月を返します。
     *
     * @return 徴収方法5月
     */
    public ChoshuHoho get徴収方法5月() {
        return ChoshuHoho.toValue(entity.getChoshuHoho5gatsu());
    }

    /**
     * 徴収方法6月を返します。
     *
     * @return 徴収方法6月
     */
    public ChoshuHoho get徴収方法6月() {
        return ChoshuHoho.toValue(entity.getChoshuHoho6gatsu());
    }

    /**
     * 徴収方法7月を返します。
     *
     * @return 徴収方法7月
     */
    public ChoshuHoho get徴収方法7月() {
        return ChoshuHoho.toValue(entity.getChoshuHoho7gatsu());
    }

    /**
     * 徴収方法8月を返します。
     *
     * @return 徴収方法8月
     */
    public ChoshuHoho get徴収方法8月() {
        return ChoshuHoho.toValue(entity.getChoshuHoho8gatsu());
    }

    /**
     * 徴収方法9月を返します。
     *
     * @return 徴収方法9月
     */
    public ChoshuHoho get徴収方法9月() {
        return ChoshuHoho.toValue(entity.getChoshuHoho9gatsu());
    }

    /**
     * 徴収方法10月を返します。
     *
     * @return 徴収方法10月
     */
    public ChoshuHoho get徴収方法10月() {
        return ChoshuHoho.toValue(entity.getChoshuHoho10gatsu());
    }

    /**
     * 徴収方法11月を返します。
     *
     * @return 徴収方法11月
     */
    public ChoshuHoho get徴収方法11月() {
        return ChoshuHoho.toValue(entity.getChoshuHoho11gatsu());
    }

    /**
     * 徴収方法12月を返します。
     *
     * @return 徴収方法12月
     */
    public ChoshuHoho get徴収方法12月() {
        return ChoshuHoho.toValue(entity.getChoshuHoho12gatsu());
    }

    /**
     * 徴収方法1月を返します。
     *
     * @return 徴収方法1月
     */
    public ChoshuHoho get徴収方法1月() {
        return ChoshuHoho.toValue(entity.getChoshuHoho1gatsu());
    }

    /**
     * 徴収方法2月を返します。
     *
     * @return 徴収方法2月
     */
    public ChoshuHoho get徴収方法2月() {
        return ChoshuHoho.toValue(entity.getChoshuHoho2gatsu());
    }

    /**
     * 徴収方法3月を返します。
     *
     * @return 徴収方法3月
     */
    public ChoshuHoho get徴収方法3月() {
        return ChoshuHoho.toValue(entity.getChoshuHoho3gatsu());
    }

    /**
     * 徴収方法翌4月を返します。
     *
     * @return 徴収方法翌4月
     */
    public ChoshuHoho get徴収方法翌4月() {
        return ChoshuHoho.toValue(entity.getChoshuHohoYoku4gatsu());
    }

    /**
     * 徴収方法翌5月を返します。
     *
     * @return 徴収方法翌5月
     */
    public ChoshuHoho get徴収方法翌5月() {
        return ChoshuHoho.toValue(entity.getChoshuHohoYoku5gatsu());
    }

    /**
     * 徴収方法翌6月を返します。
     *
     * @return 徴収方法翌6月
     */
    public ChoshuHoho get徴収方法翌6月() {
        return ChoshuHoho.toValue(entity.getChoshuHohoYoku6gatsu());
    }

    /**
     * 徴収方法翌7月を返します。
     *
     * @return 徴収方法翌7月
     */
    public ChoshuHoho get徴収方法翌7月() {
        return ChoshuHoho.toValue(entity.getChoshuHohoYoku7gatsu());
    }

    /**
     * 徴収方法翌8月を返します。
     *
     * @return 徴収方法翌8月
     */
    public ChoshuHoho get徴収方法翌8月() {
        return ChoshuHoho.toValue(entity.getChoshuHohoYoku8gatsu());
    }

    /**
     * 徴収方法翌9月を返します。
     *
     * @return 徴収方法翌9月
     */
    public ChoshuHoho get徴収方法翌9月() {
        return ChoshuHoho.toValue(entity.getChoshuHohoYoku9gatsu());
    }

    /**
     * 仮徴収_基礎年金番号を返します。
     *
     * @return 仮徴収_基礎年金番号
     */
    public RString get仮徴収_基礎年金番号() {
        return entity.getKariNenkinNo();
    }

    /**
     * 仮徴収_年金コードを返します。
     *
     * @return 仮徴収_年金コード
     */
    public RString get仮徴収_年金コード() {
        return entity.getKariNenkinCode();
    }

    /**
     * 仮徴収_捕捉月を返します。
     *
     * @return 仮徴収_捕捉月
     */
    public RString get仮徴収_捕捉月() {
        return entity.getKariHosokuM();
    }

    /**
     * 本徴収_基礎年金番号を返します。
     *
     * @return 本徴収_基礎年金番号
     */
    public RString get本徴収_基礎年金番号() {
        return entity.getHonNenkinNo();
    }

    /**
     * 本徴収_年金コードを返します。
     *
     * @return 本徴収_年金コード
     */
    public RString get本徴収_年金コード() {
        return entity.getHonNenkinCode();
    }

    /**
     * 本徴収_捕捉月を返します。
     *
     * @return 本徴収_捕捉月
     */
    public RString get本徴収_捕捉月() {
        return entity.getHonHosokuM();
    }

    /**
     * 翌年度仮徴収_基礎年金番号を返します。
     *
     * @return 翌年度仮徴収_基礎年金番号
     */
    public RString get翌年度仮徴収_基礎年金番号() {
        return entity.getYokunendoKariNenkinNo();
    }

    /**
     * 翌年度仮徴収_年金コードを返します。
     *
     * @return 翌年度仮徴収_年金コード
     */
    public RString get翌年度仮徴収_年金コード() {
        return entity.getYokunendoKariNenkinCode();
    }

    /**
     * 翌年度仮徴収_捕捉月を返します。
     *
     * @return 翌年度仮徴収_捕捉月
     */
    public RString get翌年度仮徴収_捕捉月() {
        return entity.getYokunendoKariHosokuM();
    }

    /**
     * 依頼情報送付済みか否かを返します。
     *
     * @return 送付済みならばtrue、それ以外はfalse
     */
    public boolean is依頼情報送付済み() {
        return entity.getIraiSohuzumiFlag();
    }

    /**
     * 追加依頼情報送付済みか否かを返します。
     *
     * @return 送付済みならばtrue、それ以外はfalse
     */
    public boolean is追加依頼情報送付済み() {
        return entity.getTsuikaIraiSohuzumiFlag();
    }

    /**
     * 特別徴収停止日時を返します。
     *
     * @return 特別徴収停止日時
     */
    public YMDHMS get特別徴収停止日時() {
        return entity.getTokuchoTeishiTimestamp();
    }

    /**
     * 特別徴収停止事由を返します。
     *
     * @return 特別徴収停止事由
     */
    public TokubetsuChoshuTeishiJiyu get特別徴収停止事由() {
        return entity.getTokuchoTeishiJiyuCode();
    }

    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     */
    public void set賦課年度(FukaNendo 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度.value());
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(RDateTime 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 徴収方法4月を設定します。
     *
     * @param 徴収方法4月 徴収方法4月
     */
    public void set徴収方法4月(ChoshuHoho 徴収方法4月) {
        requireNonNull(徴収方法4月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法4月"));
        entity.setChoshuHoho4gatsu(徴収方法4月.code());
    }

    /**
     * 徴収方法5月を設定します。
     *
     * @param 徴収方法5月 徴収方法5月
     */
    public void set徴収方法5月(ChoshuHoho 徴収方法5月) {
        requireNonNull(徴収方法5月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法5月"));
        entity.setChoshuHoho5gatsu(徴収方法5月.code());
    }

    /**
     * 徴収方法6月を設定します。
     *
     * @param 徴収方法6月 徴収方法6月
     */
    public void set徴収方法6月(ChoshuHoho 徴収方法6月) {
        requireNonNull(徴収方法6月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法6月"));
        entity.setChoshuHoho6gatsu(徴収方法6月.code());
    }

    /**
     * 徴収方法7月を設定します。
     *
     * @param 徴収方法7月 徴収方法7月
     */
    public void set徴収方法7月(ChoshuHoho 徴収方法7月) {
        requireNonNull(徴収方法7月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法7月"));
        entity.setChoshuHoho7gatsu(徴収方法7月.code());
    }

    /**
     * 徴収方法8月を設定します。
     *
     * @param 徴収方法8月 徴収方法8月
     */
    public void set徴収方法8月(ChoshuHoho 徴収方法8月) {
        requireNonNull(徴収方法8月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法8月"));
        entity.setChoshuHoho8gatsu(徴収方法8月.code());
    }

    /**
     * 徴収方法9月を設定します。
     *
     * @param 徴収方法9月 徴収方法9月
     */
    public void set徴収方法9月(ChoshuHoho 徴収方法9月) {
        requireNonNull(徴収方法9月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法9月"));
        entity.setChoshuHoho9gatsu(徴収方法9月.code());
    }

    /**
     * 徴収方法10月を設定します。
     *
     * @param 徴収方法10月 徴収方法10月
     */
    public void set徴収方法10月(ChoshuHoho 徴収方法10月) {
        requireNonNull(徴収方法10月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法10月"));
        entity.setChoshuHoho10gatsu(徴収方法10月.code());
    }

    /**
     * 徴収方法11月を設定します。
     *
     * @param 徴収方法11月 徴収方法11月
     */
    public void set徴収方法11月(ChoshuHoho 徴収方法11月) {
        requireNonNull(徴収方法11月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法11月"));
        entity.setChoshuHoho11gatsu(徴収方法11月.code());
    }

    /**
     * 徴収方法12月を設定します。
     *
     * @param 徴収方法12月 徴収方法12月
     */
    public void set徴収方法12月(ChoshuHoho 徴収方法12月) {
        requireNonNull(徴収方法12月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法12月"));
        entity.setChoshuHoho12gatsu(徴収方法12月.code());
    }

    /**
     * 徴収方法1月を設定します。
     *
     * @param 徴収方法1月 徴収方法1月
     */
    public void set徴収方法1月(ChoshuHoho 徴収方法1月) {
        requireNonNull(徴収方法1月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法1月"));
        entity.setChoshuHoho1gatsu(徴収方法1月.code());
    }

    /**
     * 徴収方法2月を設定します。
     *
     * @param 徴収方法2月 徴収方法2月
     */
    public void set徴収方法2月(ChoshuHoho 徴収方法2月) {
        requireNonNull(徴収方法2月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法2月"));
        entity.setChoshuHoho2gatsu(徴収方法2月.code());
    }

    /**
     * 徴収方法3月を設定します。
     *
     * @param 徴収方法3月 徴収方法3月
     */
    public void set徴収方法3月(ChoshuHoho 徴収方法3月) {
        requireNonNull(徴収方法3月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法3月"));
        entity.setChoshuHoho3gatsu(徴収方法3月.code());
    }

    /**
     * 徴収方法翌4月を設定します。
     *
     * @param 徴収方法翌4月 徴収方法翌4月
     */
    public void set徴収方法翌4月(ChoshuHoho 徴収方法翌4月) {
        requireNonNull(徴収方法翌4月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法翌4月"));
        entity.setChoshuHohoYoku4gatsu(徴収方法翌4月.code());
    }

    /**
     * 徴収方法翌5月を設定します。
     *
     * @param 徴収方法翌5月 徴収方法翌5月
     */
    public void set徴収方法翌5月(ChoshuHoho 徴収方法翌5月) {
        requireNonNull(徴収方法翌5月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法翌5月"));
        entity.setChoshuHohoYoku5gatsu(徴収方法翌5月.code());
    }

    /**
     * 徴収方法翌6月を設定します。
     *
     * @param 徴収方法翌6月 徴収方法翌6月
     */
    public void set徴収方法翌6月(ChoshuHoho 徴収方法翌6月) {
        requireNonNull(徴収方法翌6月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法翌6月"));
        entity.setChoshuHohoYoku6gatsu(徴収方法翌6月.code());
    }

    /**
     * 徴収方法翌7月を設定します。
     *
     * @param 徴収方法翌7月 徴収方法翌7月
     */
    public void set徴収方法翌7月(ChoshuHoho 徴収方法翌7月) {
        requireNonNull(徴収方法翌7月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法翌7月"));
        entity.setChoshuHohoYoku7gatsu(徴収方法翌7月.code());
    }

    /**
     * 徴収方法翌8月を設定します。
     *
     * @param 徴収方法翌8月 徴収方法翌8月
     */
    public void set徴収方法翌8月(ChoshuHoho 徴収方法翌8月) {
        requireNonNull(徴収方法翌8月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法翌8月"));
        entity.setChoshuHohoYoku8gatsu(徴収方法翌8月.code());
    }

    /**
     * 徴収方法翌9月を設定します。
     *
     * @param 徴収方法翌9月 徴収方法翌9月
     */
    public void set徴収方法翌9月(ChoshuHoho 徴収方法翌9月) {
        requireNonNull(徴収方法翌9月, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法翌9月"));
        entity.setChoshuHohoYoku9gatsu(徴収方法翌9月.code());
    }

    /**
     * 仮徴収_基礎年金番号を設定します。
     *
     * @param 仮徴収_基礎年金番号 仮徴収_基礎年金番号
     */
    public void set仮徴収_基礎年金番号(RString 仮徴収_基礎年金番号) {
        requireNonNull(仮徴収_基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("仮徴収_基礎年金番号"));
        entity.setKariNenkinNo(仮徴収_基礎年金番号);
    }

    /**
     * 仮徴収_年金コードを設定します。
     *
     * @param 仮徴収_年金コード 仮徴収_年金コード
     */
    public void set仮徴収_年金コード(RString 仮徴収_年金コード) {
        requireNonNull(仮徴収_年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("仮徴収_年金コード"));
        entity.setKariNenkinCode(仮徴収_年金コード);
    }

    /**
     * 仮徴収_捕捉月を設定します。
     *
     * @param 仮徴収_捕捉月 仮徴収_捕捉月
     */
    public void set仮徴収_捕捉月(RString 仮徴収_捕捉月) {
        requireNonNull(仮徴収_捕捉月, UrSystemErrorMessages.値がnull.getReplacedMessage("仮徴収_捕捉月"));
        entity.setKariHosokuM(仮徴収_捕捉月);
    }

    /**
     * 本徴収_基礎年金番号を設定します。
     *
     * @param 本徴収_基礎年金番号 本徴収_基礎年金番号
     */
    public void set本徴収_基礎年金番号(RString 本徴収_基礎年金番号) {
        requireNonNull(本徴収_基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("本徴収_基礎年金番号"));
        entity.setHonNenkinNo(本徴収_基礎年金番号);
    }

    /**
     * 本徴収_年金コードを設定します。
     *
     * @param 本徴収_年金コード 本徴収_年金コード
     */
    public void set本徴収_年金コード(RString 本徴収_年金コード) {
        requireNonNull(本徴収_年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("本徴収_年金コード"));
        entity.setHonNenkinCode(本徴収_年金コード);
    }

    /**
     * 本徴収_捕捉月を設定します。
     *
     * @param 本徴収_捕捉月 本徴収_捕捉月
     */
    public void set本徴収_捕捉月(RString 本徴収_捕捉月) {
        requireNonNull(本徴収_捕捉月, UrSystemErrorMessages.値がnull.getReplacedMessage("本徴収_捕捉月"));
        entity.setHonHosokuM(本徴収_捕捉月);
    }

    /**
     * 翌年度仮徴収_基礎年金番号を設定します。
     *
     * @param 翌年度仮徴収_基礎年金番号 翌年度仮徴収_基礎年金番号
     */
    public void set翌年度仮徴収_基礎年金番号(RString 翌年度仮徴収_基礎年金番号) {
        requireNonNull(翌年度仮徴収_基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("翌年度仮徴収_基礎年金番号"));
        entity.setYokunendoKariNenkinNo(翌年度仮徴収_基礎年金番号);
    }

    /**
     * 翌年度仮徴収_年金コードを設定します。
     *
     * @param 翌年度仮徴収_年金コード 翌年度仮徴収_年金コード
     */
    public void set翌年度仮徴収_年金コード(RString 翌年度仮徴収_年金コード) {
        requireNonNull(翌年度仮徴収_年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("翌年度仮徴収_年金コード"));
        entity.setYokunendoKariNenkinCode(翌年度仮徴収_年金コード);
    }

    /**
     * 翌年度仮徴収_捕捉月を設定します。
     *
     * @param 翌年度仮徴収_捕捉月 翌年度仮徴収_捕捉月
     */
    public void set翌年度仮徴収_捕捉月(RString 翌年度仮徴収_捕捉月) {
        requireNonNull(翌年度仮徴収_捕捉月, UrSystemErrorMessages.値がnull.getReplacedMessage("翌年度仮徴収_捕捉月"));
        entity.setYokunendoKariHosokuM(翌年度仮徴収_捕捉月);
    }

    /**
     * 依頼情報送付済みフラグを設定します。
     *
     * @param 依頼情報送付済みフラグ 依頼情報送付済みフラグ
     */
    public void set依頼情報送付済みフラグ(boolean 依頼情報送付済みフラグ) {
        requireNonNull(依頼情報送付済みフラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("依頼情報送付済みフラグ"));
        entity.setIraiSohuzumiFlag(依頼情報送付済みフラグ);
    }

    /**
     * 追加依頼情報送付済みフラグを設定します。
     *
     * @param 追加依頼情報送付済みフラグ 追加依頼情報送付済みフラグ
     */
    public void set追加依頼情報送付済みフラグ(boolean 追加依頼情報送付済みフラグ) {
        requireNonNull(追加依頼情報送付済みフラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("追加依頼情報送付済みフラグ"));
        entity.setTsuikaIraiSohuzumiFlag(追加依頼情報送付済みフラグ);
    }

    /**
     * 特別徴収停止日時を設定します。
     *
     * @param 特別徴収停止日時 特別徴収停止日時
     */
    public void set特別徴収停止日時(YMDHMS 特別徴収停止日時) {
        requireNonNull(特別徴収停止日時, UrSystemErrorMessages.値がnull.getReplacedMessage("特別徴収停止日時"));
        entity.setTokuchoTeishiTimestamp(特別徴収停止日時);
    }

    /**
     * 特別徴収停止事由を設定します。
     *
     * @param 特別徴収停止事由 特別徴収停止事由
     */
    public void set特別徴収停止事由(TokubetsuChoshuTeishiJiyu 特別徴収停止事由) {
        requireNonNull(特別徴収停止事由, UrSystemErrorMessages.値がnull.getReplacedMessage("特別徴収停止事由"));
        entity.setTokuchoTeishiJiyuCode(特別徴収停止事由);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
