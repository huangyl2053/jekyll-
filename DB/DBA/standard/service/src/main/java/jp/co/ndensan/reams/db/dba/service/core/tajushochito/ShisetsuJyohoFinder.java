/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tajushochito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tajushochitokureisyakanri.ShisetsuJyohoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashihenkotsuchisho.ShisetsuJyohoRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tashihenkotsuchisho.IShisetsuJyohoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu.JigyosyaType;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 介護除外住所地特例対象施設情報の取得処理です。
 *
 * @reamsid_L DBA-0380-040 duanzhanli
 */
public class ShisetsuJyohoFinder {

    private static final RString SHIKIBETSUCODE = new RString("識別コード");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShisetsuJyohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);

    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShisetsuJyohoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TaJushochiTokureisyaKanriManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TaJushochiTokureisyaKanriManager}のインスタンス
     */
    public static ShisetsuJyohoFinder createInstance() {
        return InstanceProvider.create(ShisetsuJyohoFinder.class);
    }

    /**
     * 適用情報リストを取得します。
     *
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @return 他住所地特例者管理リスト 他住所地特例者管理リスト
     */
    @Transaction
    public Map<Integer, ShisetsuJyohoRelateEntity> getTaJushochiTokureiTekiyoJyoho(ShikibetsuCode 識別コード, FlexibleDate 異動日, RString 枝番) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(SHIKIBETSUCODE.toString()));
        IShisetsuJyohoMapper mapper = mapperProvider.create(IShisetsuJyohoMapper.class);
        ShisetsuJyohoParameter parameter
                = ShisetsuJyohoParameter.createParam_TaJushochi(
                        識別コード,
                        異動日,
                        枝番,
                        JigyoshaNo.EMPTY,
                        JigyosyaType.住所地特例対象施設.getコード(),
                        DaichoType.他市町村住所地特例者.getコード());
        List<ShisetsuJyohoRelateEntity> 他市町村住所地特例情報リスト = mapper.selct他市町村住所地特例(parameter);
        List<ShisetsuJyohoRelateEntity> 適用情報リスト = new ArrayList<>();
        int i = 1;
        for (ShisetsuJyohoRelateEntity 他市町村住所地特例情報 : 他市町村住所地特例情報リスト) {
            if (i <= 2) {
                適用情報リスト.add(他市町村住所地特例情報);
                i++;
            }
        }
        Map<Integer, ShisetsuJyohoRelateEntity> 施設情報Map = new HashMap<>();
        int k = 1;
        for (ShisetsuJyohoRelateEntity 地特例情報 : 適用情報リスト) {
            RString 介護保険施設 = ShisetsuType.介護保険施設.getコード();
            RString 住所地特例対象施設 = ShisetsuType.住所地特例対象施設.getコード();
            if (介護保険施設.equals(地特例情報.get入所施設種類())) {
                ShisetsuJyohoParameter iParameter
                        = ShisetsuJyohoParameter.createParam_TaJushochi(
                                ShikibetsuCode.EMPTY,
                                FlexibleDate.EMPTY,
                                RString.EMPTY,
                                地特例情報.get入所施設コード(),
                                RString.EMPTY,
                                RString.EMPTY);
                ShisetsuJyohoRelateEntity 事業者名称Entity = mapper.get事業者名称_介護保険施設(iParameter);
                if (事業者名称Entity != null) {
                    地特例情報.set事業者名称(事業者名称Entity.get事業者名称());
                    地特例情報.set電話番号(事業者名称Entity.get電話番号());
                    地特例情報.setFax番号(事業者名称Entity.getFax番号());
                    地特例情報.set郵便番号(事業者名称Entity.get郵便番号());
                    地特例情報.set事業者住所(事業者名称Entity.get事業者住所());
                }
                施設情報Map.put(k++, 地特例情報);
            }
            if (住所地特例対象施設.equals(地特例情報.get入所施設種類())) {
                ShisetsuJyohoParameter iParameter = ShisetsuJyohoParameter.createParam_TaJushochi(
                        ShikibetsuCode.EMPTY,
                        FlexibleDate.EMPTY,
                        RString.EMPTY,
                        地特例情報.get入所施設コード(),
                        JigyosyaType.住所地特例対象施設.getコード(),
                        RString.EMPTY);
                ShisetsuJyohoRelateEntity 事業者名称Entity = mapper.get事業者名称_住所地特例対象施設(iParameter);
                if (事業者名称Entity != null) {
                    地特例情報.set事業者名称(事業者名称Entity.get事業者名称());
                    地特例情報.set電話番号(事業者名称Entity.get電話番号());
                    地特例情報.setFax番号(事業者名称Entity.getFax番号());
                    地特例情報.set郵便番号(事業者名称Entity.get郵便番号());
                    地特例情報.set事業者住所(事業者名称Entity.get事業者住所());
                }
                施設情報Map.put(k++, 地特例情報);
            }
        }
        return 施設情報Map;
    }

}
