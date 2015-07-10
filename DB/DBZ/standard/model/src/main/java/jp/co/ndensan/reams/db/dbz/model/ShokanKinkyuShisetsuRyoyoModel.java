/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3040ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求緊急時施設療養のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShokanKinkyuShisetsuRyoyoModel implements Serializable {

    private DbT3040ShokanKinkyuShisetsuRyoyoEntity entity;

    /**
     * コンストラクタです。
     */
    public ShokanKinkyuShisetsuRyoyoModel() {
        entity = new DbT3040ShokanKinkyuShisetsuRyoyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3040ShokanKinkyuShisetsuRyoyoEntity
     */
    public ShokanKinkyuShisetsuRyoyoModel(DbT3040ShokanKinkyuShisetsuRyoyoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3040ShokanKinkyuShisetsuRyoyoEntityを返します。
     *
     * @return DbT3040ShokanKinkyuShisetsuRyoyoEntity
     */
    public DbT3040ShokanKinkyuShisetsuRyoyoEntity getEntity() {
        return entity;
    }

    /**
     * DbT3040ShokanKinkyuShisetsuRyoyoEntityを設定します。
     *
     * @param entity DbT3040ShokanKinkyuShisetsuRyoyoEntity
     */
    public void setEntity(DbT3040ShokanKinkyuShisetsuRyoyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 様式番号を返します。
     *
     * @return 様式番号
     */
    public RString get様式番号() {
        return entity.getYoshikiNo();
    }

    /**
     * 順次番号を返します。
     *
     * @return 順次番号
     */
    public RString get順次番号() {
        return entity.getJunjiNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 緊急時傷病名１を返します。
     *
     * @return 緊急時傷病名１
     */
    public RString get緊急時傷病名１() {
        return entity.getKinkyuShobyoName1();
    }

    /**
     * 緊急時傷病名２を返します。
     *
     * @return 緊急時傷病名２
     */
    public RString get緊急時傷病名２() {
        return entity.getKinkyuShobyoName2();
    }

    /**
     * 緊急時傷病名３を返します。
     *
     * @return 緊急時傷病名３
     */
    public RString get緊急時傷病名３() {
        return entity.getKinkyuShobyoName3();
    }

    /**
     * 緊急時治療開始年月日１を返します。
     *
     * @return 緊急時治療開始年月日１
     */
    public FlexibleDate get緊急時治療開始年月日１() {
        return entity.getKinkyuChiryoKaishiYMD1();
    }

    /**
     * 緊急時治療開始年月日２を返します。
     *
     * @return 緊急時治療開始年月日２
     */
    public FlexibleDate get緊急時治療開始年月日２() {
        return entity.getKinkyuChiryoKaishiYMD2();
    }

    /**
     * 緊急時治療開始年月日３を返します。
     *
     * @return 緊急時治療開始年月日３
     */
    public FlexibleDate get緊急時治療開始年月日３() {
        return entity.getKinkyuChiryoKaishiYMD3();
    }

    /**
     * 往診日数を返します。
     *
     * @return 往診日数
     */
    public int get往診日数() {
        return entity.getOshinNissu();
    }

    /**
     * 往診医療機関名を返します。
     *
     * @return 往診医療機関名
     */
    public RString get往診医療機関名() {
        return entity.getOshinIryoKikanName();
    }

    /**
     * 通院日数を返します。
     *
     * @return 通院日数
     */
    public int get通院日数() {
        return entity.getTsuinNissu();
    }

    /**
     * 通院医療機関名を返します。
     *
     * @return 通院医療機関名
     */
    public RString get通院医療機関名() {
        return entity.getTsuinKikanName();
    }

    /**
     * 緊急時治療管理単位数を返します。
     *
     * @return 緊急時治療管理単位数
     */
    public int get緊急時治療管理単位数() {
        return entity.getKinkyuChiryoKanriTanisu();
    }

    /**
     * 緊急時治療管理日数を返します。
     *
     * @return 緊急時治療管理日数
     */
    public int get緊急時治療管理日数() {
        return entity.getKinkyuChiryoKanriNissu();
    }

    /**
     * 緊急時治療管理小計を返します。
     *
     * @return 緊急時治療管理小計
     */
    public int get緊急時治療管理小計() {
        return entity.getKinkyuChiryoKanriSubTotal();
    }

    /**
     * リハビリテーション単位数を返します。
     *
     * @return リハビリテーション単位数
     */
    public int getリハビリテーション単位数() {
        return entity.getRehabilitationTanisu();
    }

    /**
     * 処置単位数を返します。
     *
     * @return 処置単位数
     */
    public int get処置単位数() {
        return entity.getShochiTanisu();
    }

    /**
     * 手術単位数を返します。
     *
     * @return 手術単位数
     */
    public int get手術単位数() {
        return entity.getShujutsuTanisu();
    }

    /**
     * 麻酔単位数を返します。
     *
     * @return 麻酔単位数
     */
    public int get麻酔単位数() {
        return entity.getMasuiTanisu();
    }

    /**
     * 放射線治療単位数を返します。
     *
     * @return 放射線治療単位数
     */
    public int get放射線治療単位数() {
        return entity.getHoshasenChiryoTanisu();
    }

    /**
     * 摘要１を返します。
     *
     * @return 摘要１
     */
    public RString get摘要１() {
        return entity.getTekiyo1();
    }

    /**
     * 摘要２を返します。
     *
     * @return 摘要２
     */
    public RString get摘要２() {
        return entity.getTekiyo2();
    }

    /**
     * 摘要３を返します。
     *
     * @return 摘要３
     */
    public RString get摘要３() {
        return entity.getTekiyo3();
    }

    /**
     * 摘要４を返します。
     *
     * @return 摘要４
     */
    public RString get摘要４() {
        return entity.getTekiyo4();
    }

    /**
     * 摘要５を返します。
     *
     * @return 摘要５
     */
    public RString get摘要５() {
        return entity.getTekiyo5();
    }

    /**
     * 摘要６を返します。
     *
     * @return 摘要６
     */
    public RString get摘要６() {
        return entity.getTekiyo6();
    }

    /**
     * 摘要７を返します。
     *
     * @return 摘要７
     */
    public RString get摘要７() {
        return entity.getTekiyo7();
    }

    /**
     * 摘要８を返します。
     *
     * @return 摘要８
     */
    public RString get摘要８() {
        return entity.getTekiyo8();
    }

    /**
     * 摘要９を返します。
     *
     * @return 摘要９
     */
    public RString get摘要９() {
        return entity.getTekiyo9();
    }

    /**
     * 摘要１０を返します。
     *
     * @return 摘要１０
     */
    public RString get摘要１０() {
        return entity.getTekiyo10();
    }

    /**
     * 摘要１１を返します。
     *
     * @return 摘要１１
     */
    public RString get摘要１１() {
        return entity.getTekiyo11();
    }

    /**
     * 摘要１２を返します。
     *
     * @return 摘要１２
     */
    public RString get摘要１２() {
        return entity.getTekiyo12();
    }

    /**
     * 摘要１３を返します。
     *
     * @return 摘要１３
     */
    public RString get摘要１３() {
        return entity.getTekiyo13();
    }

    /**
     * 摘要１４を返します。
     *
     * @return 摘要１４
     */
    public RString get摘要１４() {
        return entity.getTekiyo14();
    }

    /**
     * 摘要１５を返します。
     *
     * @return 摘要１５
     */
    public RString get摘要１５() {
        return entity.getTekiyo15();
    }

    /**
     * 摘要１６を返します。
     *
     * @return 摘要１６
     */
    public RString get摘要１６() {
        return entity.getTekiyo16();
    }

    /**
     * 摘要１７を返します。
     *
     * @return 摘要１７
     */
    public RString get摘要１７() {
        return entity.getTekiyo17();
    }

    /**
     * 摘要１８を返します。
     *
     * @return 摘要１８
     */
    public RString get摘要１８() {
        return entity.getTekiyo18();
    }

    /**
     * 摘要１９を返します。
     *
     * @return 摘要１９
     */
    public RString get摘要１９() {
        return entity.getTekiyo19();
    }

    /**
     * 摘要２０を返します。
     *
     * @return 摘要２０
     */
    public RString get摘要２０() {
        return entity.getTekiyo20();
    }

    /**
     * 緊急時施設療養費合計単位数を返します。
     *
     * @return 緊急時施設療養費合計単位数
     */
    public int get緊急時施設療養費合計単位数() {
        return entity.getKinkyuShisetsuRyoyohiTotalTanisu();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    public void setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    public void set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     */
    public void set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     */
    public void set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
    }

    /**
     * 順次番号を設定します。
     *
     * @param 順次番号 順次番号
     */
    public void set順次番号(RString 順次番号) {
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        entity.setJunjiNo(順次番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 緊急時傷病名１を設定します。
     *
     * @param 緊急時傷病名１ 緊急時傷病名１
     */
    public void set緊急時傷病名１(RString 緊急時傷病名１) {
        requireNonNull(緊急時傷病名１, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時傷病名１"));
        entity.setKinkyuShobyoName1(緊急時傷病名１);
    }

    /**
     * 緊急時傷病名２を設定します。
     *
     * @param 緊急時傷病名２ 緊急時傷病名２
     */
    public void set緊急時傷病名２(RString 緊急時傷病名２) {
        requireNonNull(緊急時傷病名２, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時傷病名２"));
        entity.setKinkyuShobyoName2(緊急時傷病名２);
    }

    /**
     * 緊急時傷病名３を設定します。
     *
     * @param 緊急時傷病名３ 緊急時傷病名３
     */
    public void set緊急時傷病名３(RString 緊急時傷病名３) {
        requireNonNull(緊急時傷病名３, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時傷病名３"));
        entity.setKinkyuShobyoName3(緊急時傷病名３);
    }

    /**
     * 緊急時治療開始年月日１を設定します。
     *
     * @param 緊急時治療開始年月日１ 緊急時治療開始年月日１
     */
    public void set緊急時治療開始年月日１(FlexibleDate 緊急時治療開始年月日１) {
        requireNonNull(緊急時治療開始年月日１, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療開始年月日１"));
        entity.setKinkyuChiryoKaishiYMD1(緊急時治療開始年月日１);
    }

    /**
     * 緊急時治療開始年月日２を設定します。
     *
     * @param 緊急時治療開始年月日２ 緊急時治療開始年月日２
     */
    public void set緊急時治療開始年月日２(FlexibleDate 緊急時治療開始年月日２) {
        requireNonNull(緊急時治療開始年月日２, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療開始年月日２"));
        entity.setKinkyuChiryoKaishiYMD2(緊急時治療開始年月日２);
    }

    /**
     * 緊急時治療開始年月日３を設定します。
     *
     * @param 緊急時治療開始年月日３ 緊急時治療開始年月日３
     */
    public void set緊急時治療開始年月日３(FlexibleDate 緊急時治療開始年月日３) {
        requireNonNull(緊急時治療開始年月日３, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療開始年月日３"));
        entity.setKinkyuChiryoKaishiYMD3(緊急時治療開始年月日３);
    }

    /**
     * 往診日数を設定します。
     *
     * @param 往診日数 往診日数
     */
    public void set往診日数(int 往診日数) {
        requireNonNull(往診日数, UrSystemErrorMessages.値がnull.getReplacedMessage("往診日数"));
        entity.setOshinNissu(往診日数);
    }

    /**
     * 往診医療機関名を設定します。
     *
     * @param 往診医療機関名 往診医療機関名
     */
    public void set往診医療機関名(RString 往診医療機関名) {
        requireNonNull(往診医療機関名, UrSystemErrorMessages.値がnull.getReplacedMessage("往診医療機関名"));
        entity.setOshinIryoKikanName(往診医療機関名);
    }

    /**
     * 通院日数を設定します。
     *
     * @param 通院日数 通院日数
     */
    public void set通院日数(int 通院日数) {
        requireNonNull(通院日数, UrSystemErrorMessages.値がnull.getReplacedMessage("通院日数"));
        entity.setTsuinNissu(通院日数);
    }

    /**
     * 通院医療機関名を設定します。
     *
     * @param 通院医療機関名 通院医療機関名
     */
    public void set通院医療機関名(RString 通院医療機関名) {
        requireNonNull(通院医療機関名, UrSystemErrorMessages.値がnull.getReplacedMessage("通院医療機関名"));
        entity.setTsuinKikanName(通院医療機関名);
    }

    /**
     * 緊急時治療管理単位数を設定します。
     *
     * @param 緊急時治療管理単位数 緊急時治療管理単位数
     */
    public void set緊急時治療管理単位数(int 緊急時治療管理単位数) {
        requireNonNull(緊急時治療管理単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療管理単位数"));
        entity.setKinkyuChiryoKanriTanisu(緊急時治療管理単位数);
    }

    /**
     * 緊急時治療管理日数を設定します。
     *
     * @param 緊急時治療管理日数 緊急時治療管理日数
     */
    public void set緊急時治療管理日数(int 緊急時治療管理日数) {
        requireNonNull(緊急時治療管理日数, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療管理日数"));
        entity.setKinkyuChiryoKanriNissu(緊急時治療管理日数);
    }

    /**
     * 緊急時治療管理小計を設定します。
     *
     * @param 緊急時治療管理小計 緊急時治療管理小計
     */
    public void set緊急時治療管理小計(int 緊急時治療管理小計) {
        requireNonNull(緊急時治療管理小計, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療管理小計"));
        entity.setKinkyuChiryoKanriSubTotal(緊急時治療管理小計);
    }

    /**
     * リハビリテーション単位数を設定します。
     *
     * @param リハビリテーション単位数 リハビリテーション単位数
     */
    public void setリハビリテーション単位数(int リハビリテーション単位数) {
        requireNonNull(リハビリテーション単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション単位数"));
        entity.setRehabilitationTanisu(リハビリテーション単位数);
    }

    /**
     * 処置単位数を設定します。
     *
     * @param 処置単位数 処置単位数
     */
    public void set処置単位数(int 処置単位数) {
        requireNonNull(処置単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("処置単位数"));
        entity.setShochiTanisu(処置単位数);
    }

    /**
     * 手術単位数を設定します。
     *
     * @param 手術単位数 手術単位数
     */
    public void set手術単位数(int 手術単位数) {
        requireNonNull(手術単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("手術単位数"));
        entity.setShujutsuTanisu(手術単位数);
    }

    /**
     * 麻酔単位数を設定します。
     *
     * @param 麻酔単位数 麻酔単位数
     */
    public void set麻酔単位数(int 麻酔単位数) {
        requireNonNull(麻酔単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("麻酔単位数"));
        entity.setMasuiTanisu(麻酔単位数);
    }

    /**
     * 放射線治療単位数を設定します。
     *
     * @param 放射線治療単位数 放射線治療単位数
     */
    public void set放射線治療単位数(int 放射線治療単位数) {
        requireNonNull(放射線治療単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("放射線治療単位数"));
        entity.setHoshasenChiryoTanisu(放射線治療単位数);
    }

    /**
     * 摘要１を設定します。
     *
     * @param 摘要１ 摘要１
     */
    public void set摘要１(RString 摘要１) {
        requireNonNull(摘要１, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１"));
        entity.setTekiyo1(摘要１);
    }

    /**
     * 摘要２を設定します。
     *
     * @param 摘要２ 摘要２
     */
    public void set摘要２(RString 摘要２) {
        requireNonNull(摘要２, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要２"));
        entity.setTekiyo2(摘要２);
    }

    /**
     * 摘要３を設定します。
     *
     * @param 摘要３ 摘要３
     */
    public void set摘要３(RString 摘要３) {
        requireNonNull(摘要３, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要３"));
        entity.setTekiyo3(摘要３);
    }

    /**
     * 摘要４を設定します。
     *
     * @param 摘要４ 摘要４
     */
    public void set摘要４(RString 摘要４) {
        requireNonNull(摘要４, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要４"));
        entity.setTekiyo4(摘要４);
    }

    /**
     * 摘要５を設定します。
     *
     * @param 摘要５ 摘要５
     */
    public void set摘要５(RString 摘要５) {
        requireNonNull(摘要５, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要５"));
        entity.setTekiyo5(摘要５);
    }

    /**
     * 摘要６を設定します。
     *
     * @param 摘要６ 摘要６
     */
    public void set摘要６(RString 摘要６) {
        requireNonNull(摘要６, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要６"));
        entity.setTekiyo6(摘要６);
    }

    /**
     * 摘要７を設定します。
     *
     * @param 摘要７ 摘要７
     */
    public void set摘要７(RString 摘要７) {
        requireNonNull(摘要７, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要７"));
        entity.setTekiyo7(摘要７);
    }

    /**
     * 摘要８を設定します。
     *
     * @param 摘要８ 摘要８
     */
    public void set摘要８(RString 摘要８) {
        requireNonNull(摘要８, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要８"));
        entity.setTekiyo8(摘要８);
    }

    /**
     * 摘要９を設定します。
     *
     * @param 摘要９ 摘要９
     */
    public void set摘要９(RString 摘要９) {
        requireNonNull(摘要９, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要９"));
        entity.setTekiyo9(摘要９);
    }

    /**
     * 摘要１０を設定します。
     *
     * @param 摘要１０ 摘要１０
     */
    public void set摘要１０(RString 摘要１０) {
        requireNonNull(摘要１０, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１０"));
        entity.setTekiyo10(摘要１０);
    }

    /**
     * 摘要１１を設定します。
     *
     * @param 摘要１１ 摘要１１
     */
    public void set摘要１１(RString 摘要１１) {
        requireNonNull(摘要１１, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１１"));
        entity.setTekiyo11(摘要１１);
    }

    /**
     * 摘要１２を設定します。
     *
     * @param 摘要１２ 摘要１２
     */
    public void set摘要１２(RString 摘要１２) {
        requireNonNull(摘要１２, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１２"));
        entity.setTekiyo12(摘要１２);
    }

    /**
     * 摘要１３を設定します。
     *
     * @param 摘要１３ 摘要１３
     */
    public void set摘要１３(RString 摘要１３) {
        requireNonNull(摘要１３, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１３"));
        entity.setTekiyo13(摘要１３);
    }

    /**
     * 摘要１４を設定します。
     *
     * @param 摘要１４ 摘要１４
     */
    public void set摘要１４(RString 摘要１４) {
        requireNonNull(摘要１４, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１４"));
        entity.setTekiyo14(摘要１４);
    }

    /**
     * 摘要１５を設定します。
     *
     * @param 摘要１５ 摘要１５
     */
    public void set摘要１５(RString 摘要１５) {
        requireNonNull(摘要１５, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１５"));
        entity.setTekiyo15(摘要１５);
    }

    /**
     * 摘要１６を設定します。
     *
     * @param 摘要１６ 摘要１６
     */
    public void set摘要１６(RString 摘要１６) {
        requireNonNull(摘要１６, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１６"));
        entity.setTekiyo16(摘要１６);
    }

    /**
     * 摘要１７を設定します。
     *
     * @param 摘要１７ 摘要１７
     */
    public void set摘要１７(RString 摘要１７) {
        requireNonNull(摘要１７, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１７"));
        entity.setTekiyo17(摘要１７);
    }

    /**
     * 摘要１８を設定します。
     *
     * @param 摘要１８ 摘要１８
     */
    public void set摘要１８(RString 摘要１８) {
        requireNonNull(摘要１８, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１８"));
        entity.setTekiyo18(摘要１８);
    }

    /**
     * 摘要１９を設定します。
     *
     * @param 摘要１９ 摘要１９
     */
    public void set摘要１９(RString 摘要１９) {
        requireNonNull(摘要１９, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１９"));
        entity.setTekiyo19(摘要１９);
    }

    /**
     * 摘要２０を設定します。
     *
     * @param 摘要２０ 摘要２０
     */
    public void set摘要２０(RString 摘要２０) {
        requireNonNull(摘要２０, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要２０"));
        entity.setTekiyo20(摘要２０);
    }

    /**
     * 緊急時施設療養費合計単位数を設定します。
     *
     * @param 緊急時施設療養費合計単位数 緊急時施設療養費合計単位数
     */
    public void set緊急時施設療養費合計単位数(int 緊急時施設療養費合計単位数) {
        requireNonNull(緊急時施設療養費合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時施設療養費合計単位数"));
        entity.setKinkyuShisetsuRyoyohiTotalTanisu(緊急時施設療養費合計単位数);
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
