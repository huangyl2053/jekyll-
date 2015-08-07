/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績明細・住所地特例を管理するクラスです。
 */
public class KyufujissekiMeisaiJushochiTokureiManager {

    private final DbT3106KyufujissekiMeisaiJushochiTokureiDac dac;

    /**
     * コンストラクタです。
     */
    public KyufujissekiMeisaiJushochiTokureiManager() {
        dac = InstanceProvider.create(DbT3106KyufujissekiMeisaiJushochiTokureiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3106KyufujissekiMeisaiJushochiTokureiDac}
     */
    KyufujissekiMeisaiJushochiTokureiManager(DbT3106KyufujissekiMeisaiJushochiTokureiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付実績明細・住所地特例を返します。
     *
     * @param 交換情報識別番号 KokanJohoShikibetsuNo
     * @param 入力識別番号 InputShikibetsuNo
     * @param レコード種別コード RecodeShubetsuCode
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業所番号 JigyoshoNo
     * @param 通し番号 ToshiNo
     * @param サービス種類コード ServiceShuruiCode
     * @param サービス項目コード ServiceKomokuCode
     * @return KyufujissekiMeisaiJushochiTokurei
     */
    @Transaction
    public KyufujissekiMeisaiJushochiTokurei get給付実績明細・住所地特例(
             KokanShikibetsuCode 交換情報識別番号,
            NyuryokuShikibetsuCode 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号,
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));

        DbT3106KyufujissekiMeisaiJushochiTokureiEntity entity = dac.selectByKey(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号,
                サービス種類コード,
                サービス項目コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufujissekiMeisaiJushochiTokurei(entity);
    }

    /**
     * 給付実績明細・住所地特例を全件返します。
     *
     * @return List<KyufujissekiMeisaiJushochiTokurei>
     */
    @Transaction
    public List<KyufujissekiMeisaiJushochiTokurei> get給付実績明細・住所地特例一覧() {
        List<KyufujissekiMeisaiJushochiTokurei> businessList = new ArrayList<>();

        for (DbT3106KyufujissekiMeisaiJushochiTokureiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufujissekiMeisaiJushochiTokurei(entity));
        }

        return businessList;
    }

    /**
     * 給付実績明細・住所地特例{@link KyufujissekiMeisaiJushochiTokurei}を保存します。
     *
     * @param 給付実績明細・住所地特例 {@link KyufujissekiMeisaiJushochiTokurei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付実績明細・住所地特例(KyufujissekiMeisaiJushochiTokurei 給付実績明細・住所地特例) {
        requireNonNull(給付実績明細・住所地特例, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績明細・住所地特例"));
        if (!給付実績明細・住所地特例.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付実績明細・住所地特例.toEntity());
    }
}
