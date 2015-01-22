/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 市町村特別給付サービス事業者のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShichosonTokubetsuKyufuJigyoshaModel implements Serializable {

    private DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity;

    /**
     * コンストラクタです。
     */
    public ShichosonTokubetsuKyufuJigyoshaModel() {
        entity = new DbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3065ShichosonTokubetsuKyufuJigyoshaEntity
     */
    public ShichosonTokubetsuKyufuJigyoshaModel(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3065ShichosonTokubetsuKyufuJigyoshaEntityを返します。
     *
     * @return DbT3065ShichosonTokubetsuKyufuJigyoshaEntity
     */
    public DbT3065ShichosonTokubetsuKyufuJigyoshaEntity getEntity() {
        return entity;
    }

    /**
     * DbT3065ShichosonTokubetsuKyufuJigyoshaEntityを設定します。
     *
     * @param entity DbT3065ShichosonTokubetsuKyufuJigyoshaEntity
     */
    public void setEntity(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村特別給付用事業者番号を返します。
     *
     * @return 市町村特別給付用事業者番号
     */
    public JigyoshaNo get市町村特別給付用事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 市町村特別給付用サービスコードを返します。
     *
     * @return 市町村特別給付用サービスコード
     */
    public ServiceCode get市町村特別給付用サービスコード() {
        return entity.getServiceCode();
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
     * 介護国保連ＩＦ異動区分を返します。
     *
     * @return 介護国保連ＩＦ異動区分
     */
    public RString get介護国保連ＩＦ異動区分() {
        return entity.getIdoKubun();
    }

    /**
     * 介護国保連ＩＦ異動年月日を返します。
     *
     * @return 介護国保連ＩＦ異動年月日
     */
    public FlexibleDate get介護国保連ＩＦ異動年月日() {
        return entity.getIdoYMD();
    }

    /**
     * 介護国保連ＩＦ訂正区分を返します。
     *
     * @return 介護国保連ＩＦ訂正区分
     */
    public RString get介護国保連ＩＦ訂正区分() {
        return entity.getTeiseiKubun();
    }

    /**
     * 介護国保連ＩＦ訂正年月日を返します。
     *
     * @return 介護国保連ＩＦ訂正年月日
     */
    public FlexibleDate get介護国保連ＩＦ訂正年月日() {
        return entity.getTeiseiYMD();
    }

    /**
     * 介護国保連ＩＦ法人種別を返します。
     *
     * @return 介護国保連ＩＦ法人種別
     */
    public RString get介護国保連ＩＦ法人種別() {
        return entity.getHojinShubetsu();
    }

    /**
     * 申請者氏名_漢字を返します。
     *
     * @return 申請者氏名_漢字
     */
    public RString get申請者氏名_漢字() {
        return entity.getShinseishaNameKanji();
    }

    /**
     * 申請者氏名_カナを返します。
     *
     * @return 申請者氏名_カナ
     */
    public RString get申請者氏名_カナ() {
        return entity.getShinseishaNameKana();
    }

    /**
     * 申請者郵便番号を返します。
     *
     * @return 申請者郵便番号
     */
    public YubinNo get申請者郵便番号() {
        return entity.getShinseishaYubinNo();
    }

    /**
     * 申請者住所を返します。
     *
     * @return 申請者住所
     */
    public RString get申請者住所() {
        return entity.getShinseishaAddressKanji();
    }

    /**
     * 申請者住所_カナを返します。
     *
     * @return 申請者住所_カナ
     */
    public RString get申請者住所_カナ() {
        return entity.getShinseishaAddressKana();
    }

    /**
     * 申請者電話番号を返します。
     *
     * @return 申請者電話番号
     */
    public RString get申請者電話番号() {
        return entity.getShinseishaTelNo();
    }

    /**
     * 申請者FAX番号を返します。
     *
     * @return 申請者FAX番号
     */
    public RString get申請者FAX番号() {
        return entity.getShinseishaFaxNo();
    }

    /**
     * 事業所代表者役職を返します。
     *
     * @return 事業所代表者役職
     */
    public RString get事業所代表者役職() {
        return entity.getJigyoshoDaihyoshaYakushoku();
    }

    /**
     * 事業所代表者氏名を返します。
     *
     * @return 事業所代表者氏名
     */
    public RString get事業所代表者氏名() {
        return entity.getJigyoshoDaihyoshaNameKanji();
    }

    /**
     * 事業所代表者氏名カナを返します。
     *
     * @return 事業所代表者氏名カナ
     */
    public RString get事業所代表者氏名カナ() {
        return entity.getJigyoshoDaihyoshaNameKana();
    }

    /**
     * 事業所代表者郵便番号を返します。
     *
     * @return 事業所代表者郵便番号
     */
    public YubinNo get事業所代表者郵便番号() {
        return entity.getJigyoshoDaihyoshaYubinNo();
    }

    /**
     * 事業所代表者住所を返します。
     *
     * @return 事業所代表者住所
     */
    public RString get事業所代表者住所() {
        return entity.getJigyoshoDaihyoshaAddressKanji();
    }

    /**
     * 事業所代表者住所カナを返します。
     *
     * @return 事業所代表者住所カナ
     */
    public RString get事業所代表者住所カナ() {
        return entity.getJigyoshoDaihyoshaAddressKana();
    }

    /**
     * 事業所管理者氏名を返します。
     *
     * @return 事業所管理者氏名
     */
    public RString get事業所管理者氏名() {
        return entity.getJigyoshoKanrishaNameKanji();
    }

    /**
     * 事業所管理者氏名カナを返します。
     *
     * @return 事業所管理者氏名カナ
     */
    public RString get事業所管理者氏名カナ() {
        return entity.getJigyoshoKanrishaNameKana();
    }

    /**
     * 事業所管理者郵便番号を返します。
     *
     * @return 事業所管理者郵便番号
     */
    public YubinNo get事業所管理者郵便番号() {
        return entity.getJigyoshoKanrishaYubinNo();
    }

    /**
     * 事業所管理者住所を返します。
     *
     * @return 事業所管理者住所
     */
    public RString get事業所管理者住所() {
        return entity.getJigyoshoKanrishaAddressKanji();
    }

    /**
     * 事業所管理者住所カナを返します。
     *
     * @return 事業所管理者住所カナ
     */
    public RString get事業所管理者住所カナ() {
        return entity.getJigyoshoKanrishaAddressKana();
    }

    /**
     * サービス事業所名を返します。
     *
     * @return サービス事業所名
     */
    public RString getサービス事業所名() {
        return entity.getServiceJigyoshoNameKanji();
    }

    /**
     * サービス事業所名カナを返します。
     *
     * @return サービス事業所名カナ
     */
    public RString getサービス事業所名カナ() {
        return entity.getServiceJigyoshoNameKana();
    }

    /**
     * サービス事業所郵便番号を返します。
     *
     * @return サービス事業所郵便番号
     */
    public YubinNo getサービス事業所郵便番号() {
        return entity.getServiceJigyoshoYubinNo();
    }

    /**
     * サービス事業所住所を返します。
     *
     * @return サービス事業所住所
     */
    public RString getサービス事業所住所() {
        return entity.getServiceJigyoshoAddressKanji();
    }

    /**
     * サービス事業所住所カナを返します。
     *
     * @return サービス事業所住所カナ
     */
    public RString getサービス事業所住所カナ() {
        return entity.getServiceJigyoshoAddressKana();
    }

    /**
     * サービス事業所電話番号を返します。
     *
     * @return サービス事業所電話番号
     */
    public RString getサービス事業所電話番号() {
        return entity.getServiceJigyoshoTelNo();
    }

    /**
     * サービス事業所FAX番号を返します。
     *
     * @return サービス事業所FAX番号
     */
    public RString getサービス事業所FAX番号() {
        return entity.getServiceJigyoshoFaxNo();
    }

    /**
     * サービス事業所事業開始年月日を返します。
     *
     * @return サービス事業所事業開始年月日
     */
    public FlexibleDate getサービス事業所事業開始年月日() {
        return entity.getServiceJigyoshoJigyoKaisiYMD();
    }

    /**
     * サービス事業所事業休止年月日を返します。
     *
     * @return サービス事業所事業休止年月日
     */
    public FlexibleDate getサービス事業所事業休止年月日() {
        return entity.getServiceJigyoshoJigyoKyushiYMD();
    }

    /**
     * サービス事業所事業廃止年月日を返します。
     *
     * @return サービス事業所事業廃止年月日
     */
    public FlexibleDate getサービス事業所事業廃止年月日() {
        return entity.getServiceJigyoshoJigyoHaishiYMD();
    }

    /**
     * サービス事業所事業再開年月日を返します。
     *
     * @return サービス事業所事業再開年月日
     */
    public FlexibleDate getサービス事業所事業再開年月日() {
        return entity.getServiceJigyoshoJigyoSaikaiYMD();
    }

    /**
     * 介護保険証記載保険者番号を返します。
     *
     * @return 介護保険証記載保険者番号
     */
    public HokenshaNo get介護保険証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
    }

    /**
     * 受領委任区分を返します。
     *
     * @return 受領委任区分
     */
    public RString get受領委任区分() {
        return entity.getJuryoIninKubu();
    }

    /**
     * 市町村特別給付登録開始年月日を返します。
     *
     * @return 市町村特別給付登録開始年月日
     */
    public FlexibleDate get市町村特別給付登録開始年月日() {
        return entity.getTorokuKaishiYMD();
    }

    /**
     * 市町村特別給付登録終了年月日を返します。
     *
     * @return 市町村特別給付登録終了年月日
     */
    public FlexibleDate get市町村特別給付登録終了年月日() {
        return entity.getTorokuShuryoYMD();
    }

    /**
     * 生活保護法による指定の有を返します。
     *
     * @return 生活保護法による指定の有
     */
    public boolean get生活保護法による指定の有() {
        return entity.getSeikatsuhogoShiteiFlag();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 地域区分を返します。
     *
     * @return 地域区分
     */
    public RString get地域区分() {
        return entity.getChiikiKubun();
    }

    /**
     * 市町村特別給付用事業者番号を設定します。
     *
     * @param 市町村特別給付用事業者番号 市町村特別給付用事業者番号
     */
    public void set市町村特別給付用事業者番号(JigyoshaNo 市町村特別給付用事業者番号) {
        requireNonNull(市町村特別給付用事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用事業者番号"));
        entity.setJigyoshaNo(市町村特別給付用事業者番号);
    }

    /**
     * 市町村特別給付用サービスコードを設定します。
     *
     * @param 市町村特別給付用サービスコード 市町村特別給付用サービスコード
     */
    public void set市町村特別給付用サービスコード(ServiceCode 市町村特別給付用サービスコード) {
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        entity.setServiceCode(市町村特別給付用サービスコード);
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
     * 介護国保連ＩＦ異動区分を設定します。
     *
     * @param 介護国保連ＩＦ異動区分 介護国保連ＩＦ異動区分
     */
    public void set介護国保連ＩＦ異動区分(RString 介護国保連ＩＦ異動区分) {
        requireNonNull(介護国保連ＩＦ異動区分, UrSystemErrorMessages.値がnull.getReplacedMessage("介護国保連ＩＦ異動区分"));
        entity.setIdoKubun(介護国保連ＩＦ異動区分);
    }

    /**
     * 介護国保連ＩＦ異動年月日を設定します。
     *
     * @param 介護国保連ＩＦ異動年月日 介護国保連ＩＦ異動年月日
     */
    public void set介護国保連ＩＦ異動年月日(FlexibleDate 介護国保連ＩＦ異動年月日) {
        requireNonNull(介護国保連ＩＦ異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護国保連ＩＦ異動年月日"));
        entity.setIdoYMD(介護国保連ＩＦ異動年月日);
    }

    /**
     * 介護国保連ＩＦ訂正区分を設定します。
     *
     * @param 介護国保連ＩＦ訂正区分 介護国保連ＩＦ訂正区分
     */
    public void set介護国保連ＩＦ訂正区分(RString 介護国保連ＩＦ訂正区分) {
        requireNonNull(介護国保連ＩＦ訂正区分, UrSystemErrorMessages.値がnull.getReplacedMessage("介護国保連ＩＦ訂正区分"));
        entity.setTeiseiKubun(介護国保連ＩＦ訂正区分);
    }

    /**
     * 介護国保連ＩＦ訂正年月日を設定します。
     *
     * @param 介護国保連ＩＦ訂正年月日 介護国保連ＩＦ訂正年月日
     */
    public void set介護国保連ＩＦ訂正年月日(FlexibleDate 介護国保連ＩＦ訂正年月日) {
        requireNonNull(介護国保連ＩＦ訂正年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護国保連ＩＦ訂正年月日"));
        entity.setTeiseiYMD(介護国保連ＩＦ訂正年月日);
    }

    /**
     * 介護国保連ＩＦ法人種別を設定します。
     *
     * @param 介護国保連ＩＦ法人種別 介護国保連ＩＦ法人種別
     */
    public void set介護国保連ＩＦ法人種別(RString 介護国保連ＩＦ法人種別) {
        requireNonNull(介護国保連ＩＦ法人種別, UrSystemErrorMessages.値がnull.getReplacedMessage("介護国保連ＩＦ法人種別"));
        entity.setHojinShubetsu(介護国保連ＩＦ法人種別);
    }

    /**
     * 申請者氏名_漢字を設定します。
     *
     * @param 申請者氏名_漢字 申請者氏名_漢字
     */
    public void set申請者氏名_漢字(RString 申請者氏名_漢字) {
        requireNonNull(申請者氏名_漢字, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名_漢字"));
        entity.setShinseishaNameKanji(申請者氏名_漢字);
    }

    /**
     * 申請者氏名_カナを設定します。
     *
     * @param 申請者氏名_カナ 申請者氏名_カナ
     */
    public void set申請者氏名_カナ(RString 申請者氏名_カナ) {
        requireNonNull(申請者氏名_カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名_カナ"));
        entity.setShinseishaNameKana(申請者氏名_カナ);
    }

    /**
     * 申請者郵便番号を設定します。
     *
     * @param 申請者郵便番号 申請者郵便番号
     */
    public void set申請者郵便番号(YubinNo 申請者郵便番号) {
        requireNonNull(申請者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者郵便番号"));
        entity.setShinseishaYubinNo(申請者郵便番号);
    }

    /**
     * 申請者住所を設定します。
     *
     * @param 申請者住所 申請者住所
     */
    public void set申請者住所(RString 申請者住所) {
        requireNonNull(申請者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所"));
        entity.setShinseishaAddressKanji(申請者住所);
    }

    /**
     * 申請者住所_カナを設定します。
     *
     * @param 申請者住所_カナ 申請者住所_カナ
     */
    public void set申請者住所_カナ(RString 申請者住所_カナ) {
        requireNonNull(申請者住所_カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所_カナ"));
        entity.setShinseishaAddressKana(申請者住所_カナ);
    }

    /**
     * 申請者電話番号を設定します。
     *
     * @param 申請者電話番号 申請者電話番号
     */
    public void set申請者電話番号(RString 申請者電話番号) {
        requireNonNull(申請者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者電話番号"));
        entity.setShinseishaTelNo(申請者電話番号);
    }

    /**
     * 申請者FAX番号を設定します。
     *
     * @param 申請者FAX番号 申請者FAX番号
     */
    public void set申請者FAX番号(RString 申請者FAX番号) {
        requireNonNull(申請者FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者FAX番号"));
        entity.setShinseishaFaxNo(申請者FAX番号);
    }

    /**
     * 事業所代表者役職を設定します。
     *
     * @param 事業所代表者役職 事業所代表者役職
     */
    public void set事業所代表者役職(RString 事業所代表者役職) {
        requireNonNull(事業所代表者役職, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者役職"));
        entity.setJigyoshoDaihyoshaYakushoku(事業所代表者役職);
    }

    /**
     * 事業所代表者氏名を設定します。
     *
     * @param 事業所代表者氏名 事業所代表者氏名
     */
    public void set事業所代表者氏名(RString 事業所代表者氏名) {
        requireNonNull(事業所代表者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者氏名"));
        entity.setJigyoshoDaihyoshaNameKanji(事業所代表者氏名);
    }

    /**
     * 事業所代表者氏名カナを設定します。
     *
     * @param 事業所代表者氏名カナ 事業所代表者氏名カナ
     */
    public void set事業所代表者氏名カナ(RString 事業所代表者氏名カナ) {
        requireNonNull(事業所代表者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者氏名カナ"));
        entity.setJigyoshoDaihyoshaNameKana(事業所代表者氏名カナ);
    }

    /**
     * 事業所代表者郵便番号を設定します。
     *
     * @param 事業所代表者郵便番号 事業所代表者郵便番号
     */
    public void set事業所代表者郵便番号(YubinNo 事業所代表者郵便番号) {
        requireNonNull(事業所代表者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者郵便番号"));
        entity.setJigyoshoDaihyoshaYubinNo(事業所代表者郵便番号);
    }

    /**
     * 事業所代表者住所を設定します。
     *
     * @param 事業所代表者住所 事業所代表者住所
     */
    public void set事業所代表者住所(RString 事業所代表者住所) {
        requireNonNull(事業所代表者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者住所"));
        entity.setJigyoshoDaihyoshaAddressKanji(事業所代表者住所);
    }

    /**
     * 事業所代表者住所カナを設定します。
     *
     * @param 事業所代表者住所カナ 事業所代表者住所カナ
     */
    public void set事業所代表者住所カナ(RString 事業所代表者住所カナ) {
        requireNonNull(事業所代表者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所代表者住所カナ"));
        entity.setJigyoshoDaihyoshaAddressKana(事業所代表者住所カナ);
    }

    /**
     * 事業所管理者氏名を設定します。
     *
     * @param 事業所管理者氏名 事業所管理者氏名
     */
    public void set事業所管理者氏名(RString 事業所管理者氏名) {
        requireNonNull(事業所管理者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者氏名"));
        entity.setJigyoshoKanrishaNameKanji(事業所管理者氏名);
    }

    /**
     * 事業所管理者氏名カナを設定します。
     *
     * @param 事業所管理者氏名カナ 事業所管理者氏名カナ
     */
    public void set事業所管理者氏名カナ(RString 事業所管理者氏名カナ) {
        requireNonNull(事業所管理者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者氏名カナ"));
        entity.setJigyoshoKanrishaNameKana(事業所管理者氏名カナ);
    }

    /**
     * 事業所管理者郵便番号を設定します。
     *
     * @param 事業所管理者郵便番号 事業所管理者郵便番号
     */
    public void set事業所管理者郵便番号(YubinNo 事業所管理者郵便番号) {
        requireNonNull(事業所管理者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者郵便番号"));
        entity.setJigyoshoKanrishaYubinNo(事業所管理者郵便番号);
    }

    /**
     * 事業所管理者住所を設定します。
     *
     * @param 事業所管理者住所 事業所管理者住所
     */
    public void set事業所管理者住所(RString 事業所管理者住所) {
        requireNonNull(事業所管理者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者住所"));
        entity.setJigyoshoKanrishaAddressKanji(事業所管理者住所);
    }

    /**
     * 事業所管理者住所カナを設定します。
     *
     * @param 事業所管理者住所カナ 事業所管理者住所カナ
     */
    public void set事業所管理者住所カナ(RString 事業所管理者住所カナ) {
        requireNonNull(事業所管理者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所管理者住所カナ"));
        entity.setJigyoshoKanrishaAddressKana(事業所管理者住所カナ);
    }

    /**
     * サービス事業所名を設定します。
     *
     * @param サービス事業所名 サービス事業所名
     */
    public void setサービス事業所名(RString サービス事業所名) {
        requireNonNull(サービス事業所名, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所名"));
        entity.setServiceJigyoshoNameKanji(サービス事業所名);
    }

    /**
     * サービス事業所名カナを設定します。
     *
     * @param サービス事業所名カナ サービス事業所名カナ
     */
    public void setサービス事業所名カナ(RString サービス事業所名カナ) {
        requireNonNull(サービス事業所名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所名カナ"));
        entity.setServiceJigyoshoNameKana(サービス事業所名カナ);
    }

    /**
     * サービス事業所郵便番号を設定します。
     *
     * @param サービス事業所郵便番号 サービス事業所郵便番号
     */
    public void setサービス事業所郵便番号(YubinNo サービス事業所郵便番号) {
        requireNonNull(サービス事業所郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所郵便番号"));
        entity.setServiceJigyoshoYubinNo(サービス事業所郵便番号);
    }

    /**
     * サービス事業所住所を設定します。
     *
     * @param サービス事業所住所 サービス事業所住所
     */
    public void setサービス事業所住所(RString サービス事業所住所) {
        requireNonNull(サービス事業所住所, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所住所"));
        entity.setServiceJigyoshoAddressKanji(サービス事業所住所);
    }

    /**
     * サービス事業所住所カナを設定します。
     *
     * @param サービス事業所住所カナ サービス事業所住所カナ
     */
    public void setサービス事業所住所カナ(RString サービス事業所住所カナ) {
        requireNonNull(サービス事業所住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所住所カナ"));
        entity.setServiceJigyoshoAddressKana(サービス事業所住所カナ);
    }

    /**
     * サービス事業所電話番号を設定します。
     *
     * @param サービス事業所電話番号 サービス事業所電話番号
     */
    public void setサービス事業所電話番号(RString サービス事業所電話番号) {
        requireNonNull(サービス事業所電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所電話番号"));
        entity.setServiceJigyoshoTelNo(サービス事業所電話番号);
    }

    /**
     * サービス事業所FAX番号を設定します。
     *
     * @param サービス事業所FAX番号 サービス事業所FAX番号
     */
    public void setサービス事業所FAX番号(RString サービス事業所FAX番号) {
        requireNonNull(サービス事業所FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所FAX番号"));
        entity.setServiceJigyoshoFaxNo(サービス事業所FAX番号);
    }

    /**
     * サービス事業所事業開始年月日を設定します。
     *
     * @param サービス事業所事業開始年月日 サービス事業所事業開始年月日
     */
    public void setサービス事業所事業開始年月日(FlexibleDate サービス事業所事業開始年月日) {
        requireNonNull(サービス事業所事業開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所事業開始年月日"));
        entity.setServiceJigyoshoJigyoKaisiYMD(サービス事業所事業開始年月日);
    }

    /**
     * サービス事業所事業休止年月日を設定します。
     *
     * @param サービス事業所事業休止年月日 サービス事業所事業休止年月日
     */
    public void setサービス事業所事業休止年月日(FlexibleDate サービス事業所事業休止年月日) {
        requireNonNull(サービス事業所事業休止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所事業休止年月日"));
        entity.setServiceJigyoshoJigyoKyushiYMD(サービス事業所事業休止年月日);
    }

    /**
     * サービス事業所事業廃止年月日を設定します。
     *
     * @param サービス事業所事業廃止年月日 サービス事業所事業廃止年月日
     */
    public void setサービス事業所事業廃止年月日(FlexibleDate サービス事業所事業廃止年月日) {
        requireNonNull(サービス事業所事業廃止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所事業廃止年月日"));
        entity.setServiceJigyoshoJigyoHaishiYMD(サービス事業所事業廃止年月日);
    }

    /**
     * サービス事業所事業再開年月日を設定します。
     *
     * @param サービス事業所事業再開年月日 サービス事業所事業再開年月日
     */
    public void setサービス事業所事業再開年月日(FlexibleDate サービス事業所事業再開年月日) {
        requireNonNull(サービス事業所事業再開年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所事業再開年月日"));
        entity.setServiceJigyoshoJigyoSaikaiYMD(サービス事業所事業再開年月日);
    }

    /**
     * 介護保険証記載保険者番号を設定します。
     *
     * @param 介護保険証記載保険者番号 介護保険証記載保険者番号
     */
    public void set介護保険証記載保険者番号(HokenshaNo 介護保険証記載保険者番号) {
        requireNonNull(介護保険証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険証記載保険者番号"));
        entity.setShokisaiHokenshaNo(介護保険証記載保険者番号);
    }

    /**
     * 受領委任区分を設定します。
     *
     * @param 受領委任区分 受領委任区分
     */
    public void set受領委任区分(RString 受領委任区分) {
        requireNonNull(受領委任区分, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任区分"));
        entity.setJuryoIninKubu(受領委任区分);
    }

    /**
     * 市町村特別給付登録開始年月日を設定します。
     *
     * @param 市町村特別給付登録開始年月日 市町村特別給付登録開始年月日
     */
    public void set市町村特別給付登録開始年月日(FlexibleDate 市町村特別給付登録開始年月日) {
        requireNonNull(市町村特別給付登録開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付登録開始年月日"));
        entity.setTorokuKaishiYMD(市町村特別給付登録開始年月日);
    }

    /**
     * 市町村特別給付登録終了年月日を設定します。
     *
     * @param 市町村特別給付登録終了年月日 市町村特別給付登録終了年月日
     */
    public void set市町村特別給付登録終了年月日(FlexibleDate 市町村特別給付登録終了年月日) {
        requireNonNull(市町村特別給付登録終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付登録終了年月日"));
        entity.setTorokuShuryoYMD(市町村特別給付登録終了年月日);
    }

    /**
     * 生活保護法による指定の有を設定します。
     *
     * @param 生活保護法による指定の有 生活保護法による指定の有
     */
    public void set生活保護法による指定の有(boolean 生活保護法による指定の有) {
        requireNonNull(生活保護法による指定の有, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護法による指定の有"));
        entity.setSeikatsuhogoShiteiFlag(生活保護法による指定の有);
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
    }

    /**
     * 地域区分を設定します。
     *
     * @param 地域区分 地域区分
     */
    public void set地域区分(RString 地域区分) {
        requireNonNull(地域区分, UrSystemErrorMessages.値がnull.getReplacedMessage("地域区分"));
        entity.setChiikiKubun(地域区分);
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
