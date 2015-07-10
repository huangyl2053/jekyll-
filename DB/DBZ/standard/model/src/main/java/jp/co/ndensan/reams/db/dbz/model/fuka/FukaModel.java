/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.fuka;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.GaitoHigaitoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.code.kyotsu.ChoteiJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 賦課のモデルクラスです。
 *
 * @author n3317 塚田萌
 */
public class FukaModel implements Serializable {

    private DbT2002FukaEntity entity;

    /**
     * コンストラクタです。
     */
    public FukaModel() {
        entity = new DbT2002FukaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT2002FukaEntity
     */
    public FukaModel(DbT2002FukaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT2002FukaEntityを返します。
     *
     * @return DbT2002FukaEntity
     */
    public DbT2002FukaEntity getEntity() {
        return entity;
    }

    /**
     * DbT2002FukaEntityを設定します。
     *
     * @param entity DbT2002FukaEntity
     */
    public void setEntity(DbT2002FukaEntity entity) {
        this.entity = entity;
    }

    /**
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public ChoteiNendo get調定年度() {
        return new ChoteiNendo(entity.getChoteiNendo());
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
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return entity.getTsuchishoNo();
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return entity.getSetaiCode();
    }

    /**
     * 世帯員数を返します。
     *
     * @return 世帯員数
     */
    public int get世帯員数() {
        return entity.getSetaiInsu();
    }

    /**
     * 資格取得日を返します。
     *
     * @return 資格取得日
     */
    public FlexibleDate get資格取得日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格取得事由を返します。
     *
     * @return 資格取得事由
     */
    public RString get資格取得事由() {
        return entity.getShikakuShutokuJiyu();
    }

    /**
     * 資格喪失日を返します。
     *
     * @return 資格喪失日
     */
    public FlexibleDate get資格喪失日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失事由を返します。
     *
     * @return 資格喪失事由
     */
    public RString get資格喪失事由() {
        return entity.getShikakuSoshitsuJiyu();
    }

    /**
     * 生活保護扶助種類を返します。
     *
     * @return 生活保護扶助種類
     */
    public RString get生活保護扶助種類() {
        return entity.getSeihofujoShurui();
    }

    /**
     * 生保開始日を返します。
     *
     * @return 生保開始日
     */
    public FlexibleDate get生保開始日() {
        return entity.getSeihoKaishiYMD();
    }

    /**
     * 生保廃止日を返します。
     *
     * @return 生保廃止日
     */
    public FlexibleDate get生保廃止日() {
        return entity.getSeihoHaishiYMD();
    }

    /**
     * 老年開始日を返します。
     *
     * @return 老年開始日
     */
    public FlexibleDate get老年開始日() {
        return entity.getRonenKaishiYMD();
    }

    /**
     * 老年廃止日を返します。
     *
     * @return 老年廃止日
     */
    public FlexibleDate get老年廃止日() {
        return entity.getRonenHaishiYMD();
    }

    /**
     * 賦課期日を返します。
     *
     * @return 賦課期日
     */
    public FlexibleDate get賦課期日() {
        return entity.getFukaYMD();
    }

    /**
     * 課税区分を返します。
     *
     * @return 課税区分
     */
    public KazeiKubun get課税区分() {
        return KazeiKubun.toValue(entity.getKazeiKubun());
    }

    /**
     * 世帯課税区分を返します。
     *
     * @return 世帯課税区分
     */
    public KazeiKubun get世帯課税区分() {
        return KazeiKubun.toValue(entity.getSetaikazeiKubun());
    }

    /**
     * 合計所得金額を返します。
     *
     * @return 合計所得金額
     */
    public Decimal get合計所得金額() {
        return entity.getGokeiShotokuGaku();
    }

    /**
     * 公的年金収入額を返します。
     *
     * @return 公的年金収入額
     */
    public Decimal get公的年金収入額() {
        return entity.getNenkinShunyuGaku();
    }

    /**
     * 保険料段階を返します。
     *
     * @return 保険料段階
     */
    public RString get保険料段階() {
        return entity.getHokenryoDankai();
    }

    /**
     * 保険料算定段階1を返します。
     *
     * @return 保険料算定段階1
     */
    public RString get保険料算定段階1() {
        return entity.getHokenryoDankai1();
    }

    /**
     * 算定年額保険料1を返します。
     *
     * @return 算定年額保険料1
     */
    public Decimal get算定年額保険料1() {
        return entity.getNengakuHokenryo1();
    }

    /**
     * 月割開始年月1を返します。
     *
     * @return 月割開始年月1
     */
    public FlexibleYearMonth get月割開始年月1() {
        return entity.getTsukiwariStartYM1();
    }

    /**
     * 月割終了年月1を返します。
     *
     * @return 月割終了年月1
     */
    public FlexibleYearMonth get月割終了年月1() {
        return entity.getTsukiwariEndYM1();
    }

    /**
     * 保険料算定段階2を返します。
     *
     * @return 保険料算定段階2
     */
    public RString get保険料算定段階2() {
        return entity.getHokenryoDankai2();
    }

    /**
     * 算定年額保険料2を返します。
     *
     * @return 算定年額保険料2
     */
    public Decimal get算定年額保険料2() {
        return entity.getNengakuHokenryo2();
    }

    /**
     * 月割開始年月2を返します。
     *
     * @return 月割開始年月2
     */
    public FlexibleYearMonth get月割開始年月2() {
        return entity.getTsukiwariStartYM2();
    }

    /**
     * 月割終了年月2を返します。
     *
     * @return 月割終了年月2
     */
    public FlexibleYearMonth get月割終了年月2() {
        return entity.getTsukiwariEndYM2();
    }

    /**
     * 調定日時を返します。
     *
     * @return 調定日時
     */
    public RDateTime get調定日時() {
        return entity.getChoteiTimestamp();
    }

    /**
     * 調定事由1を返します。
     *
     * @return 調定事由1
     */
    public ChoteiJiyu get調定事由1() {
        return entity.getChoteiJiyu1();
    }

    /**
     * 調定事由2を返します。
     *
     * @return 調定事由2
     */
    public ChoteiJiyu get調定事由2() {
        return entity.getChoteiJiyu2();
    }

    /**
     * 調定事由3を返します。
     *
     * @return 調定事由3
     */
    public ChoteiJiyu get調定事由3() {
        return entity.getChoteiJiyu3();
    }

    /**
     * 調定事由4を返します。
     *
     * @return 調定事由4
     */
    public ChoteiJiyu get調定事由4() {
        return entity.getChoteiJiyu4();
    }

    /**
     * 更正月を返します。
     *
     * @return 更正月
     */
    public RString get更正月() {
        return entity.getKoseiM();
    }

    /**
     * 減免前介護保険料_年額を返します。
     *
     * @return 減免前介護保険料_年額
     */
    public Decimal get減免前介護保険料_年額() {
        return entity.getGemmenMaeHokenryo();
    }

    /**
     * 減免額を返します。
     *
     * @return 減免額
     */
    public Decimal get減免額() {
        return entity.getGemmenGaku();
    }

    /**
     * 確定介護保険料_年額を返します。
     *
     * @return 確定介護保険料_年額
     */
    public Decimal get確定介護保険料_年額() {
        return entity.getKakuteiHokenryo();
    }

    /**
     * 保険料段階_仮算定時を返します。
     *
     * @return 保険料段階_仮算定時
     */
    public RString get保険料段階_仮算定時() {
        return entity.getHokenryoDankaiKarisanntei();
    }

    /**
     * 徴収方法処理日時を返します。
     *
     * @return 徴収方法処理日時
     */
    public RDateTime get徴収方法処理日時() {
        return entity.getChoshuHohoShoriTimestamp();
    }

    /**
     * 異動基準日時を返します。
     *
     * @return 異動基準日時
     */
    public RDateTime get異動基準日時() {
        return entity.getIdoKijunTimestamp();
    }

    /**
     * 口座区分を返します。
     *
     * @return 口座区分
     */
    public GaitoHigaitoKubun get口座区分() {
        return GaitoHigaitoKubun.toValue(entity.getKozaKubun());
    }

    /**
     * 境界層区分を返します。
     *
     * @return 境界層区分
     */
    public GaitoHigaitoKubun get境界層区分() {
        return GaitoHigaitoKubun.toValue(entity.getKyokaisoKubun());
    }

    /**
     * 職権区分を返します。
     *
     * @return 職権区分
     */
    public GaitoHigaitoKubun get職権区分() {
        return GaitoHigaitoKubun.toValue(entity.getShokkenKubun());
    }

    /**
     * 賦課市町村コードを返します。
     *
     * @return 賦課市町村コード
     */
    public LasdecCode get賦課市町村コード() {
        return entity.getFukaShichosonCode();
    }

    /**
     * 調定年度を設定します。
     *
     * @param 調定年度 調定年度
     */
    public void set調定年度(ChoteiNendo 調定年度) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        entity.setChoteiNendo(調定年度.value());
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
     * 通知書番号を設定します。
     *
     * @param 通知書番号 通知書番号
     */
    public void set通知書番号(TsuchishoNo 通知書番号) {
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        entity.setTsuchishoNo(通知書番号);
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
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 世帯コードを設定します。
     *
     * @param 世帯コード 世帯コード
     */
    public void set世帯コード(SetaiCode 世帯コード) {
        requireNonNull(世帯コード, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯コード"));
        entity.setSetaiCode(世帯コード);
    }

    /**
     * 世帯員数を設定します。
     *
     * @param 世帯員数 世帯員数
     */
    public void set世帯員数(int 世帯員数) {
        requireNonNull(世帯員数, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員数"));
        entity.setSetaiInsu(世帯員数);
    }

    /**
     * 資格取得日を設定します。
     *
     * @param 資格取得日 資格取得日
     */
    public void set資格取得日(FlexibleDate 資格取得日) {
        requireNonNull(資格取得日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得日"));
        entity.setShikakuShutokuYMD(資格取得日);
    }

    /**
     * 資格取得事由を設定します。
     *
     * @param 資格取得事由 資格取得事由
     */
    public void set資格取得事由(RString 資格取得事由) {
        requireNonNull(資格取得事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得事由"));
        entity.setShikakuShutokuJiyu(資格取得事由);
    }

    /**
     * 資格喪失日を設定します。
     *
     * @param 資格喪失日 資格喪失日
     */
    public void set資格喪失日(FlexibleDate 資格喪失日) {
        requireNonNull(資格喪失日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失日"));
        entity.setShikakuSoshitsuYMD(資格喪失日);
    }

    /**
     * 資格喪失事由を設定します。
     *
     * @param 資格喪失事由 資格喪失事由
     */
    public void set資格喪失事由(RString 資格喪失事由) {
        requireNonNull(資格喪失事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失事由"));
        entity.setShikakuSoshitsuJiyu(資格喪失事由);
    }

    /**
     * 生活保護扶助種類を設定します。
     *
     * @param 生活保護扶助種類 生活保護扶助種類
     */
    public void set生活保護扶助種類(RString 生活保護扶助種類) {
        requireNonNull(生活保護扶助種類, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護扶助種類"));
        entity.setSeihofujoShurui(生活保護扶助種類);
    }

    /**
     * 生保開始日を設定します。
     *
     * @param 生保開始日 生保開始日
     */
    public void set生保開始日(FlexibleDate 生保開始日) {
        requireNonNull(生保開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("生保開始日"));
        entity.setSeihoKaishiYMD(生保開始日);
    }

    /**
     * 生保廃止日を設定します。
     *
     * @param 生保廃止日 生保廃止日
     */
    public void set生保廃止日(FlexibleDate 生保廃止日) {
        requireNonNull(生保廃止日, UrSystemErrorMessages.値がnull.getReplacedMessage("生保廃止日"));
        entity.setSeihoHaishiYMD(生保廃止日);
    }

    /**
     * 老年開始日を設定します。
     *
     * @param 老年開始日 老年開始日
     */
    public void set老年開始日(FlexibleDate 老年開始日) {
        requireNonNull(老年開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("老年開始日"));
        entity.setRonenKaishiYMD(老年開始日);
    }

    /**
     * 老年廃止日を設定します。
     *
     * @param 老年廃止日 老年廃止日
     */
    public void set老年廃止日(FlexibleDate 老年廃止日) {
        requireNonNull(老年廃止日, UrSystemErrorMessages.値がnull.getReplacedMessage("老年廃止日"));
        entity.setRonenHaishiYMD(老年廃止日);
    }

    /**
     * 賦課期日を設定します。
     *
     * @param 賦課期日 賦課期日
     */
    public void set賦課期日(FlexibleDate 賦課期日) {
        requireNonNull(賦課期日, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課期日"));
        entity.setFukaYMD(賦課期日);
    }

    /**
     * 課税区分を設定します。
     *
     * @param 課税区分 課税区分
     */
    public void set課税区分(KazeiKubun 課税区分) {
        requireNonNull(課税区分, UrSystemErrorMessages.値がnull.getReplacedMessage("課税区分"));
        entity.setKazeiKubun(課税区分.code());
    }

    /**
     * 世帯課税区分を設定します。
     *
     * @param 世帯課税区分 世帯課税区分
     */
    public void set世帯課税区分(KazeiKubun 世帯課税区分) {
        requireNonNull(世帯課税区分, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯課税区分"));
        entity.setSetaikazeiKubun(世帯課税区分.code());
    }

    /**
     * 合計所得金額を設定します。
     *
     * @param 合計所得金額 合計所得金額
     */
    public void set合計所得金額(Decimal 合計所得金額) {
        requireNonNull(合計所得金額, UrSystemErrorMessages.値がnull.getReplacedMessage("合計所得金額"));
        entity.setGokeiShotokuGaku(合計所得金額);
    }

    /**
     * 公的年金収入額を設定します。
     *
     * @param 公的年金収入額 公的年金収入額
     */
    public void set公的年金収入額(Decimal 公的年金収入額) {
        requireNonNull(公的年金収入額, UrSystemErrorMessages.値がnull.getReplacedMessage("公的年金収入額"));
        entity.setNenkinShunyuGaku(公的年金収入額);
    }

    /**
     * 保険料段階を設定します。
     *
     * @param 保険料段階 保険料段階
     */
    public void set保険料段階(RString 保険料段階) {
        requireNonNull(保険料段階, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料段階"));
        entity.setHokenryoDankai(保険料段階);
    }

    /**
     * 保険料算定段階1を設定します。
     *
     * @param 保険料算定段階1 保険料算定段階1
     */
    public void set保険料算定段階1(RString 保険料算定段階1) {
        requireNonNull(保険料算定段階1, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料算定段階1"));
        entity.setHokenryoDankai1(保険料算定段階1);
    }

    /**
     * 算定年額保険料1を設定します。
     *
     * @param 算定年額保険料1 算定年額保険料1
     */
    public void set算定年額保険料1(Decimal 算定年額保険料1) {
        requireNonNull(算定年額保険料1, UrSystemErrorMessages.値がnull.getReplacedMessage("算定年額保険料1"));
        entity.setNengakuHokenryo1(算定年額保険料1);
    }

    /**
     * 月割開始年月1を設定します。
     *
     * @param 月割開始年月1 月割開始年月1
     */
    public void set月割開始年月1(FlexibleYearMonth 月割開始年月1) {
        requireNonNull(月割開始年月1, UrSystemErrorMessages.値がnull.getReplacedMessage("月割開始年月1"));
        entity.setTsukiwariStartYM1(月割開始年月1);
    }

    /**
     * 月割終了年月1を設定します。
     *
     * @param 月割終了年月1 月割終了年月1
     */
    public void set月割終了年月1(FlexibleYearMonth 月割終了年月1) {
        requireNonNull(月割終了年月1, UrSystemErrorMessages.値がnull.getReplacedMessage("月割終了年月1"));
        entity.setTsukiwariEndYM1(月割終了年月1);
    }

    /**
     * 保険料算定段階2を設定します。
     *
     * @param 保険料算定段階2 保険料算定段階2
     */
    public void set保険料算定段階2(RString 保険料算定段階2) {
        requireNonNull(保険料算定段階2, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料算定段階2"));
        entity.setHokenryoDankai2(保険料算定段階2);
    }

    /**
     * 算定年額保険料2を設定します。
     *
     * @param 算定年額保険料2 算定年額保険料2
     */
    public void set算定年額保険料2(Decimal 算定年額保険料2) {
        requireNonNull(算定年額保険料2, UrSystemErrorMessages.値がnull.getReplacedMessage("算定年額保険料2"));
        entity.setNengakuHokenryo2(算定年額保険料2);
    }

    /**
     * 月割開始年月2を設定します。
     *
     * @param 月割開始年月2 月割開始年月2
     */
    public void set月割開始年月2(FlexibleYearMonth 月割開始年月2) {
        requireNonNull(月割開始年月2, UrSystemErrorMessages.値がnull.getReplacedMessage("月割開始年月2"));
        entity.setTsukiwariStartYM2(月割開始年月2);
    }

    /**
     * 月割終了年月2を設定します。
     *
     * @param 月割終了年月2 月割終了年月2
     */
    public void set月割終了年月2(FlexibleYearMonth 月割終了年月2) {
        requireNonNull(月割終了年月2, UrSystemErrorMessages.値がnull.getReplacedMessage("月割終了年月2"));
        entity.setTsukiwariEndYM2(月割終了年月2);
    }

    /**
     * 調定日時を設定します。
     *
     * @param 調定日時 調定日時
     */
    public void set調定日時(RDateTime 調定日時) {
        requireNonNull(調定日時, UrSystemErrorMessages.値がnull.getReplacedMessage("調定日時"));
        entity.setChoteiTimestamp(調定日時);
    }

    /**
     * 調定事由1を設定します。
     *
     * @param 調定事由1 調定事由1
     */
    public void set調定事由1(ChoteiJiyu 調定事由1) {
        requireNonNull(調定事由1, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由1"));
        entity.setChoteiJiyu1(調定事由1);
    }

    /**
     * 調定事由2を設定します。
     *
     * @param 調定事由2 調定事由2
     */
    public void set調定事由2(ChoteiJiyu 調定事由2) {
        requireNonNull(調定事由2, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由2"));
        entity.setChoteiJiyu2(調定事由2);
    }

    /**
     * 調定事由3を設定します。
     *
     * @param 調定事由3 調定事由3
     */
    public void set調定事由3(ChoteiJiyu 調定事由3) {
        requireNonNull(調定事由3, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由3"));
        entity.setChoteiJiyu3(調定事由3);
    }

    /**
     * 調定事由4を設定します。
     *
     * @param 調定事由4 調定事由4
     */
    public void set調定事由4(ChoteiJiyu 調定事由4) {
        requireNonNull(調定事由4, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由4"));
        entity.setChoteiJiyu4(調定事由4);
    }

    /**
     * 更正月を設定します。
     *
     * @param 更正月 更正月
     */
    public void set更正月(RString 更正月) {
        requireNonNull(更正月, UrSystemErrorMessages.値がnull.getReplacedMessage("更正月"));
        entity.setKoseiM(更正月);
    }

    /**
     * 減免前介護保険料_年額を設定します。
     *
     * @param 減免前介護保険料_年額 減免前介護保険料_年額
     */
    public void set減免前介護保険料_年額(Decimal 減免前介護保険料_年額) {
        requireNonNull(減免前介護保険料_年額, UrSystemErrorMessages.値がnull.getReplacedMessage("減免前介護保険料_年額"));
        entity.setGemmenMaeHokenryo(減免前介護保険料_年額);
    }

    /**
     * 減免額を設定します。
     *
     * @param 減免額 減免額
     */
    public void set減免額(Decimal 減免額) {
        requireNonNull(減免額, UrSystemErrorMessages.値がnull.getReplacedMessage("減免額"));
        entity.setGemmenGaku(減免額);
    }

    /**
     * 確定介護保険料_年額を設定します。
     *
     * @param 確定介護保険料_年額 確定介護保険料_年額
     */
    public void set確定介護保険料_年額(Decimal 確定介護保険料_年額) {
        requireNonNull(確定介護保険料_年額, UrSystemErrorMessages.値がnull.getReplacedMessage("確定介護保険料_年額"));
        entity.setKakuteiHokenryo(確定介護保険料_年額);
    }

    /**
     * 保険料段階_仮算定時を設定します。
     *
     * @param 保険料段階_仮算定時 保険料段階_仮算定時
     */
    public void set保険料段階_仮算定時(RString 保険料段階_仮算定時) {
        requireNonNull(保険料段階_仮算定時, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料段階_仮算定時"));
        entity.setHokenryoDankaiKarisanntei(保険料段階_仮算定時);
    }

    /**
     * 徴収方法処理日時を設定します。
     *
     * @param 徴収方法処理日時 徴収方法処理日時
     */
    public void set徴収方法処理日時(RDateTime 徴収方法処理日時) {
        requireNonNull(徴収方法処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法処理日時"));
        entity.setChoshuHohoShoriTimestamp(徴収方法処理日時);
    }

    /**
     * 異動基準日時を設定します。
     *
     * @param 異動基準日時 異動基準日時
     */
    public void set異動基準日時(RDateTime 異動基準日時) {
        requireNonNull(異動基準日時, UrSystemErrorMessages.値がnull.getReplacedMessage("異動基準日時"));
        entity.setIdoKijunTimestamp(異動基準日時);
    }

    /**
     * 口座区分を設定します。
     *
     * @param 口座区分 口座区分
     */
    public void set口座区分(GaitoHigaitoKubun 口座区分) {
        requireNonNull(口座区分, UrSystemErrorMessages.値がnull.getReplacedMessage("口座区分"));
        entity.setKozaKubun(口座区分.getCode());
    }

    /**
     * 境界層区分を設定します。
     *
     * @param 境界層区分 境界層区分
     */
    public void set境界層区分(GaitoHigaitoKubun 境界層区分) {
        requireNonNull(境界層区分, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層区分"));
        entity.setKyokaisoKubun(境界層区分.getCode());
    }

    /**
     * 職権区分を設定します。
     *
     * @param 職権区分 職権区分
     */
    public void set職権区分(GaitoHigaitoKubun 職権区分) {
        requireNonNull(職権区分, UrSystemErrorMessages.値がnull.getReplacedMessage("職権区分"));
        entity.setShokkenKubun(職権区分.getCode());
    }

    /**
     * 賦課市町村コードを設定します。
     *
     * @param 賦課市町村コード 賦課市町村コード
     */
    public void set賦課市町村コード(LasdecCode 賦課市町村コード) {
        requireNonNull(賦課市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課市町村コード"));
        entity.setFukaShichosonCode(賦課市町村コード);
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
