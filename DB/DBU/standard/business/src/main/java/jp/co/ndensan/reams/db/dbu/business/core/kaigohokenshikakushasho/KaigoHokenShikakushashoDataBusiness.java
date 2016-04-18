/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.kaigohokenshikakushasho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigohokenshikakushasho.KyufuseigenDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigohokenshikakushasho.NyushoShisetsuDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigohokenshikakushasho.ShuruiShikyuGendoKizyunngakuEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.KaigoHokenShikakushashoDataEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険資格者証の帳票出力用のビジネスです。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
public class KaigoHokenShikakushashoDataBusiness {

    private final KaigoHokenShikakushashoDataEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 介護保険資格者証の帳票出力用のエンティティ
     */
    public KaigoHokenShikakushashoDataBusiness(KaigoHokenShikakushashoDataEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険資格者証の帳票出力用のエンティティ"));
    }

    /**
     * 有効期限を取得します。
     *
     * @return 有効期限
     */
    public RString get有効期限() {
        return entity.getYukoKigen();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者住所を取得します。
     *
     * @return 被保険者住所
     */
    public RString get被保険者住所() {
        return entity.getJusho();
    }

    /**
     * 被保険者フリガナを取得します。
     *
     * @return 被保険者フリガナ
     */
    public RString get被保険者フリガナ() {
        return entity.getHihokenshaNameKana();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 明治を取得します。
     *
     * @return 明治
     */
    public RString get明治() {
        return entity.getBirthGengoMeiji();
    }

    /**
     * 大正を取得します。
     *
     * @return 大正
     */
    public RString get大正() {
        return entity.getBirthGengoTaisho();
    }

    /**
     * 昭和を取得します。
     *
     * @return 昭和
     */
    public RString get昭和() {
        return entity.getBirthGengoShowa();
    }

    /**
     * 被保険者生年月日を取得します。
     *
     * @return 被保険者生年月日
     */
    public RString get被保険者生年月日() {
        return entity.getBirthYMD();
    }

    /**
     * 被保険者性別を取得します。
     *
     * @return 被保険者性別
     */
    public RString get被保険者性別() {
        return entity.getSeibetsu();
    }

    /**
     * 交付年月日を取得します。
     *
     * @return 交付年月日
     */
    public RString get交付年月日() {
        return entity.getKofuYMD();
    }

    /**
     * 要介護状態区分等を取得します。
     *
     * @return 要介護状態区分等
     */
    public RString get要介護状態区分等() {
        return entity.getYokaigoJotaiKubun();
    }

    /**
     * 認定年月日を取得します。
     *
     * @return 認定年月日
     */
    public RString get認定年月日() {
        return entity.getNinteiYMD();
    }

    /**
     * 認定の有効期間開始年月日を取得します。
     *
     * @return 認定の有効期間開始年月日
     */
    public RString get認定の有効期間開始年月日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 認定の有効期間終了年月日を取得します。
     *
     * @return 認定の有効期間終了年月日
     */
    public RString get認定の有効期間終了年月日() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 居宅サービス等の区分支給限度開始年月日を取得します。
     *
     * @return 居宅サービス等の区分支給限度開始年月日
     */
    public RString get居宅サービス等の区分支給限度開始年月日() {
        return entity.getKubunShikyuYukoKaishiYMD();
    }

    /**
     * 居宅サービス等の区分支給限度終了年月日を取得します。
     *
     * @return 居宅サービス等の区分支給限度終了年月日
     */
    public RString get居宅サービス等の区分支給限度終了年月日() {
        return entity.getKubunShikyuYukoShuryoYMD();
    }

    /**
     * 居宅サービス等の基準額を取得します。
     *
     * @return 居宅サービス等の基準額
     */
    public RString get居宅サービス等の基準額() {
        return entity.getKizyunngaku();
    }

    /**
     * 居宅サービス等の単位種類を取得します。
     *
     * @return 居宅サービス等の単位種類
     */
    public RString get居宅サービス等の単位種類() {
        return entity.getTaniShurui();
    }

    /**
     * 居宅サービス等の単位を取得します。
     *
     * @return 居宅サービス等の単位
     */
    public RString get居宅サービス等の単位() {
        return entity.getTani();
    }

    /**
     * うち種類支給限度基準額の情報を取得します。
     *
     * @return うち種類支給限度基準額の情報
     */
    public List<ShuruiShikyuGendoKizyunngakuEntity> getうち種類支給限度基準額の情報() {
        return entity.getShikyuGendoKizyungakuList();
    }

    /**
     * 認定審査会の意見及びサービスの種類の指定を取得します。
     *
     * @return 認定審査会の意見及びサービスの種類の指定
     */
    public RString get認定審査会の意見及びサービスの種類の指定() {
        return entity.getServiceShitei();
    }

    /**
     * 給付制限の情報を取得します。
     *
     * @return 給付制限の情報
     */
    public List<KyufuseigenDataEntity> get給付制限の情報() {
        return entity.getKyufuseigenDataList();
    }

    /**
     * 支援事業者情報の名称の内容1を取得します。
     *
     * @return 支援事業者情報の名称の内容1
     */
    public RString get支援事業者情報の名称の内容1() {
        return entity.getJigyoshaName1();
    }

    /**
     * 支援事業者情報の名称の届出年月日1を取得します。
     *
     * @return 支援事業者情報の名称の届出年月日1
     */
    public RString get支援事業者情報の名称の届出年月日1() {
        return entity.getTodokedeYMD1();
    }

    /**
     * 支援事業者情報の名称の内容2を取得します。
     *
     * @return 支援事業者情報の名称の内容2
     */
    public RString get支援事業者情報の名称の内容2() {
        return entity.getJigyoshaName2();
    }

    /**
     * 支援事業者情報の名称の内容アスタリスク2を取得します。
     *
     * @return 支援事業者情報の名称の内容アスタリスク2
     */
    public RString get支援事業者情報の名称の内容アスタリスク2() {
        return entity.getJigyoshaName2Asutarisuku();
    }

    /**
     * 支援事業者情報の名称の内容取消2を取得します。
     *
     * @return 支援事業者情報の名称の内容取消2
     */
    public RString get支援事業者情報の名称の内容取消2() {
        return entity.getJigyoshaName2Masshosen();
    }

    /**
     * 支援事業者情報の名称の届出年月日2を取得します。
     *
     * @return 支援事業者情報の名称の届出年月日2
     */
    public RString get支援事業者情報の名称の届出年月日2() {
        return entity.getTodokedeYMD2();
    }

    /**
     * 支援事業者情報の名称の届出年月日アスタリスク2を取得します。
     *
     * @return 支援事業者情報の名称の届出年月日アスタリスク2
     */
    public RString get支援事業者情報の名称の届出年月日アスタリスク2() {
        return entity.getTodokedeYMD2Asutarisuku();
    }

    /**
     * 支援事業者情報の名称の届出年月日取消2を取得します。
     *
     * @return 支援事業者情報の名称の届出年月日取消2
     */
    public RString get支援事業者情報の名称の届出年月日取消2() {
        return entity.getTodokedeYMD2Masshosen();
    }

    /**
     * 支援事業者情報の名称の内容3を取得します。
     *
     * @return 支援事業者情報の名称の内容3
     */
    public RString get支援事業者情報の名称の内容3() {
        return entity.getJigyoshaName3();
    }

    /**
     * 支援事業者情報の名称の内容アスタリスク3を取得します。
     *
     * @return 支援事業者情報の名称の内容アスタリスク3
     */
    public RString get支援事業者情報の名称の内容アスタリスク3() {
        return entity.getJigyoshaName3Asutarisuku();
    }

    /**
     * 支援事業者情報の名称の内容取消3を取得します。
     *
     * @return 支援事業者情報の名称の内容取消3
     */
    public RString get支援事業者情報の名称の内容取消3() {
        return entity.getJigyoshaName3Masshosen();
    }

    /**
     * 支援事業者情報の名称の届出年月日3を取得します。
     *
     * @return 支援事業者情報の名称の届出年月日3
     */
    public RString get支援事業者情報の名称の届出年月日3() {
        return entity.getTodokedeYMD3();
    }

    /**
     * 支援事業者情報の名称の届出年月日アスタリスク3を取得します。
     *
     * @return 支援事業者情報の名称の届出年月日アスタリスク3
     */
    public RString get支援事業者情報の名称の届出年月日アスタリスク3() {
        return entity.getTodokedeYMD3Asutarisuku();
    }

    /**
     * 支援事業者情報の名称の届出年月日取消3を取得します。
     *
     * @return 支援事業者情報の名称の届出年月日取消3
     */
    public RString get支援事業者情報の名称の届出年月日取消3() {
        return entity.getTodokedeYMD3Masshosen();
    }

    /**
     * 介護保険施設等の情報を取得します。
     *
     * @return 介護保険施設等の情報
     */
    public List<NyushoShisetsuDataEntity> get介護保険施設等の情報() {
        return entity.getNyushoShisetsuDataList();
    }

    /**
     * 施設入所を取得します。
     *
     * @return 施設入所
     */
    public RString get施設入所() {
        return entity.getShisetsuNyusho();
    }

    /**
     * 施設入院を取得します。
     *
     * @return 施設入院
     */
    public RString get施設入院() {
        return entity.getShisetsuNyuin();
    }

    /**
     * 施設退所を取得します。
     *
     * @return 施設退所
     */
    public RString get施設退所() {
        return entity.getShisetsuTaisho();
    }

    /**
     * 施設退院を取得します。
     *
     * @return 施設退院
     */
    public RString get施設退院() {
        return entity.getShisetsuTaiin();
    }

    /**
     * 保険者番号及びに保険者の名称及び印の保険者番号を取得します。
     *
     * @return 保険者番号及びに保険者の名称及び印の保険者番号
     */
    public RString get保険者番号及びに保険者の名称及び印の保険者番号() {
        return entity.getHokenshaNo();
    }

    /**
     * 保険者番号及びに保険者の名称及び印の住所を取得します。
     *
     * @return 保険者番号及びに保険者の名称及び印の住所
     */
    public RString get保険者番号及びに保険者の名称及び印の住所() {
        return entity.getHokenshaJusho();
    }

    /**
     * 保険者番号及びに保険者の名称及び印の保険者名称を取得します。
     *
     * @return 保険者番号及びに保険者の名称及び印の保険者名称
     */
    public RString get保険者番号及びに保険者の名称及び印の保険者名称() {
        return entity.getHokenshaName();
    }

    /**
     * 保険者番号及びに保険者の名称及び印の電話番号を取得します。
     *
     * @return 保険者番号及びに保険者の名称及び印の電話番号
     */
    public RString get保険者番号及びに保険者の名称及び印の電話番号() {
        return entity.getHokenshaTelno();
    }

    /**
     * 保険者番号及びに保険者の名称及び印の印字編集を取得します。
     *
     * @return 保険者番号及びに保険者の名称及び印の印字編集
     */
    public RString get保険者番号及びに保険者の名称及び印の印字編集() {
        return entity.getDenshiKoin();
    }

    /**
     * 連番を取得します。
     *
     * @return 連番
     */
    public RString get連番() {
        return entity.getRemban();
    }

    /**
     * サーブタイトルを取得します。
     *
     * @return サーブタイトル
     */
    public RString getサーブタイトル() {
        return entity.getSubTitle();
    }
}
