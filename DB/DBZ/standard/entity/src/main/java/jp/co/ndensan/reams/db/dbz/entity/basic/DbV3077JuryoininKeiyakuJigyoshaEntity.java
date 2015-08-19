package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 受領委任事業者Aliveテーブルのエンティティクラスです。
 */
public class DbV3077JuryoininKeiyakuJigyoshaEntity extends DbTableEntityBase<DbV3077JuryoininKeiyakuJigyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbV3077JuryoininKeiyakuJigyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private RString jigyoshaKeiyakuNo;
    private FlexibleDate kaishiYMD;
    private int rirekiNo;
    private FlexibleDate shuryoYMD;
    private FlexibleDate todokedeYMD;
    private RString todokedeAddress;
    private RString todokedeJigyoshaName;
    private RString todokedeDaihyoshaName;
    private RString kozaShubetsu;
    private RString kozaNo;
    private RString tsuchoKigo;
    private RString tsuchoNo;
    private AtenaKanaMeisho kozaMeiginin;
    private AtenaMeisho kozaMeigininKanji;
    private TelNo jigyoshaFaxNo;
    private FlexibleDate keiyakuTorokuYMD;
    private RString sofusakiBusho;
    private RString eigyoKeitai;
    private boolean jutakuKaishuKeiyakuUmu;
    private boolean tokuteiFukushiYoguHanbaiKeiyakuUmu;
    private boolean shokanbaraiKyufuKeiyakuUmu;
    private boolean kogakuKyufuKeiyakuUmu;
    private JigyoshaNo keiyakuJigyoshaNo;
    private boolean toriatsukaiKakuyakushoUmu;

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * jigyoshaKeiyakuNoのgetメソッドです。
     *
     * @return jigyoshaKeiyakuNo
     */
    public RString getJigyoshaKeiyakuNo() {
        return jigyoshaKeiyakuNo;
    }

    /**
     * jigyoshaKeiyakuNoのsetメソッドです。
     *
     * @param jigyoshaKeiyakuNo jigyoshaKeiyakuNo
     */
    public void setJigyoshaKeiyakuNo(RString jigyoshaKeiyakuNo) {
        this.jigyoshaKeiyakuNo = jigyoshaKeiyakuNo;
    }

    /**
     * kaishiYMDのgetメソッドです。
     *
     * @return kaishiYMD
     */
    public FlexibleDate getKaishiYMD() {
        return kaishiYMD;
    }

    /**
     * kaishiYMDのsetメソッドです。
     *
     * @param kaishiYMD kaishiYMD
     */
    public void setKaishiYMD(FlexibleDate kaishiYMD) {
        this.kaishiYMD = kaishiYMD;
    }

    /**
     * rirekiNoのgetメソッドです。
     *
     * @return rirekiNo
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * rirekiNoのsetメソッドです。
     *
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * shuryoYMDのgetメソッドです。
     *
     * @return shuryoYMD
     */
    public FlexibleDate getShuryoYMD() {
        return shuryoYMD;
    }

    /**
     * shuryoYMDのsetメソッドです。
     *
     * @param shuryoYMD shuryoYMD
     */
    public void setShuryoYMD(FlexibleDate shuryoYMD) {
        this.shuryoYMD = shuryoYMD;
    }

    /**
     * todokedeYMDのgetメソッドです。
     *
     * @return todokedeYMD
     */
    public FlexibleDate getTodokedeYMD() {
        return todokedeYMD;
    }

    /**
     * todokedeYMDのsetメソッドです。
     *
     * @param todokedeYMD todokedeYMD
     */
    public void setTodokedeYMD(FlexibleDate todokedeYMD) {
        this.todokedeYMD = todokedeYMD;
    }

    /**
     * todokedeAddressのgetメソッドです。
     *
     * @return todokedeAddress
     */
    public RString getTodokedeAddress() {
        return todokedeAddress;
    }

    /**
     * todokedeAddressのsetメソッドです。
     *
     * @param todokedeAddress todokedeAddress
     */
    public void setTodokedeAddress(RString todokedeAddress) {
        this.todokedeAddress = todokedeAddress;
    }

    /**
     * todokedeJigyoshaNameのgetメソッドです。
     *
     * @return todokedeJigyoshaName
     */
    public RString getTodokedeJigyoshaName() {
        return todokedeJigyoshaName;
    }

    /**
     * todokedeJigyoshaNameのsetメソッドです。
     *
     * @param todokedeJigyoshaName todokedeJigyoshaName
     */
    public void setTodokedeJigyoshaName(RString todokedeJigyoshaName) {
        this.todokedeJigyoshaName = todokedeJigyoshaName;
    }

    /**
     * todokedeDaihyoshaNameのgetメソッドです。
     *
     * @return todokedeDaihyoshaName
     */
    public RString getTodokedeDaihyoshaName() {
        return todokedeDaihyoshaName;
    }

    /**
     * todokedeDaihyoshaNameのsetメソッドです。
     *
     * @param todokedeDaihyoshaName todokedeDaihyoshaName
     */
    public void setTodokedeDaihyoshaName(RString todokedeDaihyoshaName) {
        this.todokedeDaihyoshaName = todokedeDaihyoshaName;
    }

    /**
     * kozaShubetsuのgetメソッドです。
     *
     * @return kozaShubetsu
     */
    public RString getKozaShubetsu() {
        return kozaShubetsu;
    }

    /**
     * kozaShubetsuのsetメソッドです。
     *
     * @param kozaShubetsu kozaShubetsu
     */
    public void setKozaShubetsu(RString kozaShubetsu) {
        this.kozaShubetsu = kozaShubetsu;
    }

    /**
     * kozaNoのgetメソッドです。
     *
     * @return kozaNo
     */
    public RString getKozaNo() {
        return kozaNo;
    }

    /**
     * kozaNoのsetメソッドです。
     *
     * @param kozaNo kozaNo
     */
    public void setKozaNo(RString kozaNo) {
        this.kozaNo = kozaNo;
    }

    /**
     * tsuchoKigoのgetメソッドです。
     *
     * @return tsuchoKigo
     */
    public RString getTsuchoKigo() {
        return tsuchoKigo;
    }

    /**
     * tsuchoKigoのsetメソッドです。
     *
     * @param tsuchoKigo tsuchoKigo
     */
    public void setTsuchoKigo(RString tsuchoKigo) {
        this.tsuchoKigo = tsuchoKigo;
    }

    /**
     * tsuchoNoのgetメソッドです。
     *
     * @return tsuchoNo
     */
    public RString getTsuchoNo() {
        return tsuchoNo;
    }

    /**
     * tsuchoNoのsetメソッドです。
     *
     * @param tsuchoNo tsuchoNo
     */
    public void setTsuchoNo(RString tsuchoNo) {
        this.tsuchoNo = tsuchoNo;
    }

    /**
     * kozaMeigininのgetメソッドです。
     *
     * @return kozaMeiginin
     */
    public AtenaKanaMeisho getKozaMeiginin() {
        return kozaMeiginin;
    }

    /**
     * kozaMeigininのsetメソッドです。
     *
     * @param kozaMeiginin kozaMeiginin
     */
    public void setKozaMeiginin(AtenaKanaMeisho kozaMeiginin) {
        this.kozaMeiginin = kozaMeiginin;
    }

    /**
     * kozaMeigininKanjiのgetメソッドです。
     *
     * @return kozaMeigininKanji
     */
    public AtenaMeisho getKozaMeigininKanji() {
        return kozaMeigininKanji;
    }

    /**
     * kozaMeigininKanjiのsetメソッドです。
     *
     * @param kozaMeigininKanji kozaMeigininKanji
     */
    public void setKozaMeigininKanji(AtenaMeisho kozaMeigininKanji) {
        this.kozaMeigininKanji = kozaMeigininKanji;
    }

    /**
     * jigyoshaFaxNoのgetメソッドです。
     *
     * @return jigyoshaFaxNo
     */
    public TelNo getJigyoshaFaxNo() {
        return jigyoshaFaxNo;
    }

    /**
     * jigyoshaFaxNoのsetメソッドです。
     *
     * @param jigyoshaFaxNo jigyoshaFaxNo
     */
    public void setJigyoshaFaxNo(TelNo jigyoshaFaxNo) {
        this.jigyoshaFaxNo = jigyoshaFaxNo;
    }

    /**
     * keiyakuTorokuYMDのgetメソッドです。
     *
     * @return keiyakuTorokuYMD
     */
    public FlexibleDate getKeiyakuTorokuYMD() {
        return keiyakuTorokuYMD;
    }

    /**
     * keiyakuTorokuYMDのsetメソッドです。
     *
     * @param keiyakuTorokuYMD keiyakuTorokuYMD
     */
    public void setKeiyakuTorokuYMD(FlexibleDate keiyakuTorokuYMD) {
        this.keiyakuTorokuYMD = keiyakuTorokuYMD;
    }

    /**
     * sofusakiBushoのgetメソッドです。
     *
     * @return sofusakiBusho
     */
    public RString getSofusakiBusho() {
        return sofusakiBusho;
    }

    /**
     * sofusakiBushoのsetメソッドです。
     *
     * @param sofusakiBusho sofusakiBusho
     */
    public void setSofusakiBusho(RString sofusakiBusho) {
        this.sofusakiBusho = sofusakiBusho;
    }

    /**
     * eigyoKeitaiのgetメソッドです。
     *
     * @return eigyoKeitai
     */
    public RString getEigyoKeitai() {
        return eigyoKeitai;
    }

    /**
     * eigyoKeitaiのsetメソッドです。
     *
     * @param eigyoKeitai eigyoKeitai
     */
    public void setEigyoKeitai(RString eigyoKeitai) {
        this.eigyoKeitai = eigyoKeitai;
    }

    /**
     * jutakuKaishuKeiyakuUmuのgetメソッドです。
     *
     * @return jutakuKaishuKeiyakuUmu
     */
    public boolean getJutakuKaishuKeiyakuUmu() {
        return jutakuKaishuKeiyakuUmu;
    }

    /**
     * jutakuKaishuKeiyakuUmuのsetメソッドです。
     *
     * @param jutakuKaishuKeiyakuUmu jutakuKaishuKeiyakuUmu
     */
    public void setJutakuKaishuKeiyakuUmu(boolean jutakuKaishuKeiyakuUmu) {
        this.jutakuKaishuKeiyakuUmu = jutakuKaishuKeiyakuUmu;
    }

    /**
     * tokuteiFukushiYoguHanbaiKeiyakuUmuのgetメソッドです。
     *
     * @return tokuteiFukushiYoguHanbaiKeiyakuUmu
     */
    public boolean getTokuteiFukushiYoguHanbaiKeiyakuUmu() {
        return tokuteiFukushiYoguHanbaiKeiyakuUmu;
    }

    /**
     * tokuteiFukushiYoguHanbaiKeiyakuUmuのsetメソッドです。
     *
     * @param tokuteiFukushiYoguHanbaiKeiyakuUmu tokuteiFukushiYoguHanbaiKeiyakuUmu
     */
    public void setTokuteiFukushiYoguHanbaiKeiyakuUmu(boolean tokuteiFukushiYoguHanbaiKeiyakuUmu) {
        this.tokuteiFukushiYoguHanbaiKeiyakuUmu = tokuteiFukushiYoguHanbaiKeiyakuUmu;
    }

    /**
     * shokanbaraiKyufuKeiyakuUmuのgetメソッドです。
     *
     * @return shokanbaraiKyufuKeiyakuUmu
     */
    public boolean getShokanbaraiKyufuKeiyakuUmu() {
        return shokanbaraiKyufuKeiyakuUmu;
    }

    /**
     * shokanbaraiKyufuKeiyakuUmuのsetメソッドです。
     *
     * @param shokanbaraiKyufuKeiyakuUmu shokanbaraiKyufuKeiyakuUmu
     */
    public void setShokanbaraiKyufuKeiyakuUmu(boolean shokanbaraiKyufuKeiyakuUmu) {
        this.shokanbaraiKyufuKeiyakuUmu = shokanbaraiKyufuKeiyakuUmu;
    }

    /**
     * kogakuKyufuKeiyakuUmuのgetメソッドです。
     *
     * @return kogakuKyufuKeiyakuUmu
     */
    public boolean getKogakuKyufuKeiyakuUmu() {
        return kogakuKyufuKeiyakuUmu;
    }

    /**
     * kogakuKyufuKeiyakuUmuのsetメソッドです。
     *
     * @param kogakuKyufuKeiyakuUmu kogakuKyufuKeiyakuUmu
     */
    public void setKogakuKyufuKeiyakuUmu(boolean kogakuKyufuKeiyakuUmu) {
        this.kogakuKyufuKeiyakuUmu = kogakuKyufuKeiyakuUmu;
    }

    /**
     * keiyakuJigyoshaNoのgetメソッドです。
     *
     * @return keiyakuJigyoshaNo
     */
    public JigyoshaNo getKeiyakuJigyoshaNo() {
        return keiyakuJigyoshaNo;
    }

    /**
     * keiyakuJigyoshaNoのsetメソッドです。
     *
     * @param keiyakuJigyoshaNo keiyakuJigyoshaNo
     */
    public void setKeiyakuJigyoshaNo(JigyoshaNo keiyakuJigyoshaNo) {
        this.keiyakuJigyoshaNo = keiyakuJigyoshaNo;
    }

    /**
     * toriatsukaiKakuyakushoUmuのgetメソッドです。
     *
     * @return toriatsukaiKakuyakushoUmu
     */
    public boolean getToriatsukaiKakuyakushoUmu() {
        return toriatsukaiKakuyakushoUmu;
    }

    /**
     * toriatsukaiKakuyakushoUmuのsetメソッドです。
     *
     * @param toriatsukaiKakuyakushoUmu toriatsukaiKakuyakushoUmu
     */
    public void setToriatsukaiKakuyakushoUmu(boolean toriatsukaiKakuyakushoUmu) {
        this.toriatsukaiKakuyakushoUmu = toriatsukaiKakuyakushoUmu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV3077JuryoininKeiyakuJigyoshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbV3077JuryoininKeiyakuJigyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV3077JuryoininKeiyakuJigyoshaEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV3077JuryoininKeiyakuJigyoshaEntity entity) {
        this.jigyoshaKeiyakuNo = entity.jigyoshaKeiyakuNo;
        this.kaishiYMD = entity.kaishiYMD;
        this.rirekiNo = entity.rirekiNo;
        this.shuryoYMD = entity.shuryoYMD;
        this.todokedeYMD = entity.todokedeYMD;
        this.todokedeAddress = entity.todokedeAddress;
        this.todokedeJigyoshaName = entity.todokedeJigyoshaName;
        this.todokedeDaihyoshaName = entity.todokedeDaihyoshaName;
        this.kozaShubetsu = entity.kozaShubetsu;
        this.kozaNo = entity.kozaNo;
        this.tsuchoKigo = entity.tsuchoKigo;
        this.tsuchoNo = entity.tsuchoNo;
        this.kozaMeiginin = entity.kozaMeiginin;
        this.kozaMeigininKanji = entity.kozaMeigininKanji;
        this.jigyoshaFaxNo = entity.jigyoshaFaxNo;
        this.keiyakuTorokuYMD = entity.keiyakuTorokuYMD;
        this.sofusakiBusho = entity.sofusakiBusho;
        this.eigyoKeitai = entity.eigyoKeitai;
        this.jutakuKaishuKeiyakuUmu = entity.jutakuKaishuKeiyakuUmu;
        this.tokuteiFukushiYoguHanbaiKeiyakuUmu = entity.tokuteiFukushiYoguHanbaiKeiyakuUmu;
        this.shokanbaraiKyufuKeiyakuUmu = entity.shokanbaraiKyufuKeiyakuUmu;
        this.kogakuKyufuKeiyakuUmu = entity.kogakuKyufuKeiyakuUmu;
        this.keiyakuJigyoshaNo = entity.keiyakuJigyoshaNo;
        this.toriatsukaiKakuyakushoUmu = entity.toriatsukaiKakuyakushoUmu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaKeiyakuNo, kaishiYMD, rirekiNo, shuryoYMD, todokedeYMD, todokedeAddress, todokedeJigyoshaName, todokedeDaihyoshaName, kozaShubetsu, kozaNo, tsuchoKigo, tsuchoNo, kozaMeiginin, kozaMeigininKanji, jigyoshaFaxNo, keiyakuTorokuYMD, sofusakiBusho, eigyoKeitai, jutakuKaishuKeiyakuUmu, tokuteiFukushiYoguHanbaiKeiyakuUmu, shokanbaraiKyufuKeiyakuUmu, kogakuKyufuKeiyakuUmu, keiyakuJigyoshaNo, toriatsukaiKakuyakushoUmu);
    }

// </editor-fold>
}
