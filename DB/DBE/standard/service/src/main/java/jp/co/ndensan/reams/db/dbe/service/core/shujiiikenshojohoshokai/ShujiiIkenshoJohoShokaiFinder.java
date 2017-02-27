/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshojohoshokai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshojohoshokai.ShujiiIkenshoJohoShokaiBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshojohoshokai.ShujiiIkenshoJohoShokaiEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshojohoshokai.IShujiiIkenshoJohoShokaiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書情報照会の検索クラス
 * 
 * @author n3213
 */
public class ShujiiIkenshoJohoShokaiFinder {
    
    private final MapperProvider mapperProvider;
    
    ShujiiIkenshoJohoShokaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoJohoShokaiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoJohoShokaiFinder}のインスタンス
     */
    public static ShujiiIkenshoJohoShokaiFinder createInstance() {
        return InstanceProvider.create(ShujiiIkenshoJohoShokaiFinder.class);
    }

    @Transaction
    public SearchResult<ShujiiIkenshoJohoShokaiBusiness> select主治医意見書(ShinseishoKanriNo shinseishoKanriNo, int iraiRirekiNo) {
        requireNonNull(shinseishoKanriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(iraiRirekiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("依頼履歴番号"));
        IShujiiIkenshoJohoShokaiMapper mapper = mapperProvider.create(IShujiiIkenshoJohoShokaiMapper.class);
        ShujiiIkenshoJohoShokaiEntity entity = mapper.select主治医意見書情報(shinseishoKanriNo.value(), iraiRirekiNo);
        List<ShujiiIkenshoJohoShokaiBusiness> business = new ArrayList<>();
        business.add(new ShujiiIkenshoJohoShokaiBusiness(entity));
        return SearchResult.of(business, 0, false);
    }
}
