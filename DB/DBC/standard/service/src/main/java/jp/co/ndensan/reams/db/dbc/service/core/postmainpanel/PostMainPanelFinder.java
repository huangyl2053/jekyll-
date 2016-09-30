/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.postmainpanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.postmainpanel.PostMainPanelMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.postmainpanel.PostMainPanelEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.postmainpanel.IPostMainPanelMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBC0510011_国保・後期高齢資格異動情報取込
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
public class PostMainPanelFinder {

    private final MapperProvider mapperProvider;

    PostMainPanelFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    PostMainPanelFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link PostMainPanelFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link PostMainPanelFinder}のインスタンス
     */
    public static PostMainPanelFinder createInstance() {
        return InstanceProvider.create(PostMainPanelFinder.class);
    }

    /**
     * 再発行対象取得
     *
     * @param paramter HashMap<String, Object>
     * @return 再発行対象リスト
     */
    public List<List> getPostMainPanel(Map<String, Object> paramter) {
        requireNonNull(paramter, UrSystemErrorMessages.値がnull.getReplacedMessage("paramter"));
        List<List> listDataSource = new ArrayList();
        IPostMainPanelMapper mapper = mapperProvider.create(IPostMainPanelMapper.class);
        List<PostMainPanelEntity> 再発行対象リスト = mapper.get広域保険者for00(paramter);
        if (再発行対象リスト != null && !再発行対象リスト.isEmpty()) {
            for (PostMainPanelEntity item : 再発行対象リスト) {
                List items = new ArrayList();
                RString 市町村コード = new RString(item.get市町村コード().toString());
                if (!RString.isNullOrEmpty(市町村コード)) {
                    items.add(市町村コード);
                } else {
                    items.add(RString.EMPTY);
                }
                if (item.get市町村名称() != null && !item.get市町村名称().toString().isEmpty()) {
                    items.add(new RString(item.get市町村名称().toString()));
                } else {
                    items.add(RString.EMPTY);
                }
                if (item.get基準日時() != null && !item.get基準日時().toString().isEmpty()) {
                    items.add(new RString(item.get基準日時().toString()));
                } else {
                    items.add(RString.EMPTY);
                }
                if (item.get対象開始日時() != null && !item.get対象開始日時().toString().isEmpty()) {
                    items.add(new RString(item.get対象開始日時().toString()));
                } else {
                    items.add(RString.EMPTY);
                }
                items.add(item.get市町村識別ID());
                listDataSource.add(items);
            }
        } else {
            return null;
        }
        return listDataSource;
    }

    /**
     * 再発行対象取得
     *
     * @param paramter PostMainPanelMybatisParameter
     * @return 再発行対象リスト
     */
    public List<List> getPostMainPanel(PostMainPanelMybatisParameter paramter) {
        requireNonNull(paramter, UrSystemErrorMessages.値がnull.getReplacedMessage("paramter"));
        List<List> businessList = new ArrayList<>();
        IPostMainPanelMapper mapper = mapperProvider.create(IPostMainPanelMapper.class);
        List<PostMainPanelEntity> 再発行対象リスト = mapper.get広域保険者(paramter);
        if (再発行対象リスト != null && !再発行対象リスト.isEmpty()) {
            for (PostMainPanelEntity item : 再発行対象リスト) {
                List items = new ArrayList();
                RString 市町村コード = new RString(item.get市町村コード().toString());
                if (!RString.isNullOrEmpty(市町村コード)) {
                    items.add(市町村コード);
                } else {
                    items.add(RString.EMPTY);
                }
                if (item.get市町村名称() != null && !item.get市町村名称().toString().isEmpty()) {
                    items.add(new RString(item.get市町村名称().toString()));
                } else {
                    items.add(RString.EMPTY);
                }
                if (item.get基準日時() != null && !item.get基準日時().toString().isEmpty()) {
                    items.add(new RString(item.get基準日時().toString()));
                } else {
                    items.add(RString.EMPTY);
                }
                if (item.get対象開始日時() != null && !item.get対象開始日時().toString().isEmpty()) {
                    items.add(new RString(item.get対象開始日時().toString()));
                } else {
                    items.add(RString.EMPTY);
                }
                items.add(item.get市町村識別ID());

                businessList.add(items);
            }
        } else {
            return null;
        }
        return businessList;
    }
}
