/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.seikatsuhogorireki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.seikatsuhogorireki.SeikaatsuhogoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.seikatsuhogorireki.SeikatsuhogoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.seikatsuhogorireki.SeikatsuhogoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.seikatsuhogorireki.ISeikatsuhogoRirekiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.KaigoRyoDairiNofuKubunType;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 生活保護履歴初期化データ取得です。
 *
 * @reamsid_L DBZ-4520-010 zhangzhiming
 */
public class SeikatsuhogoRirekiFinder {

    private final MapperProvider mapperProvider;
    private final RString 連結 = new RString("／");

    /**
     * コンストラクタです。
     */
    SeikatsuhogoRirekiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    SeikatsuhogoRirekiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SeikatsuhogoRirekiFinder}のインスタンスを返します。
     *
     * @return SeikatsuhogoRirekiFinder
     */
    public static SeikatsuhogoRirekiFinder createInstance() {
        return InstanceProvider.create(SeikatsuhogoRirekiFinder.class);
    }

    /**
     * 入力された検索条件によって、生活保護情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 業務コード GyomuCode
     * @return SearchResult<SeikatsuhogoRelateEntity>
     */
    @Transaction
    public SearchResult<SeikaatsuhogoBusiness> search生活保護情報(ShikibetsuCode 識別コード, GyomuCode 業務コード) {
        List<SeikaatsuhogoBusiness> business = new ArrayList<>();
        if (RString.isNullOrEmpty(識別コード.getColumnValue()) || RString.isNullOrEmpty(業務コード.getColumnValue())) {
            return SearchResult.of(business, 0, false);
        }
        ISeikatsuhogoRirekiMapper mapper = mapperProvider.create(ISeikatsuhogoRirekiMapper.class);
        SeikatsuhogoParameter parameter = SeikatsuhogoParameter.createParameter(識別コード, 業務コード);
        List<SeikatsuhogoRelateEntity> entityList = mapper.get生活保護履歴情報(parameter);
        if (entityList != null && !entityList.isEmpty()) {
            List<SeikatsuhogoRelateEntity> list = new ArrayList<>();
            SeikatsuhogoRelateEntity relateEntity2 = new SeikatsuhogoRelateEntity();
            RStringBuilder shuruiCode = new RStringBuilder();
            RStringBuilder codeRyakusho = new RStringBuilder();
            RStringBuilder teishiKaishi = new RStringBuilder();
            RStringBuilder teishiShuryo = new RStringBuilder();
            RString builder = RString.EMPTY;
            for (SeikatsuhogoRelateEntity entity : entityList) {
                SeikatsuhogoRelateEntity relateEntity = new SeikatsuhogoRelateEntity();
                relateEntity.setShikibetsuCode(entity.getShikibetsuCode());
                relateEntity.setGyomuCode(entity.getGyomuCode());
                relateEntity.setJukyuKaishiYMD(entity.getJukyuKaishiYMD());
                relateEntity.setJukyuHaishiYMD(entity.getJukyuHaishiYMD());
                relateEntity.setJukyushaNo(entity.getJukyushaNo());
                if (entity.getKaigoRyoDairiNofuKubun() != null) {
                    relateEntity.setKaigoRyoDairiNofuKubun(KaigoRyoDairiNofuKubunType.toValue(entity.getKaigoRyoDairiNofuKubun()).toRString());
                }
                relateEntity.setKaigoRyoDairiNofuYM(entity.getKaigoRyoDairiNofuYM());
                relateEntity.setKyugoShisetsuNyuTaishoKubun(entity.getKyugoShisetsuNyuTaishoKubun());
                relateEntity.setKyugoShisetsuNyutaishoYMD(entity.getKyugoShisetsuNyutaishoYMD());
                relateEntity.setJukyuTeishiKaishiYMD(entity.getJukyuTeishiKaishiYMD());
                relateEntity.setJukyuTeishiShuryoYMD(entity.getJukyuTeishiShuryoYMD());
                if (!RString.isNullOrEmpty(entity.getFujoShuruiCode())) {
                    shuruiCode.append(entity.getFujoShuruiCode());
                    shuruiCode.append(連結);
                }
                if (!RString.isNullOrEmpty(entity.getJukyuTeishiKaishiYMD())) {
                    teishiKaishi.append(entity.getJukyuTeishiKaishiYMD());
                    teishiKaishi.append(連結);
                }
                if (!RString.isNullOrEmpty(entity.getJukyuTeishiShuryoYMD())) {
                    teishiShuryo.append(entity.getJukyuTeishiShuryoYMD());
                    teishiShuryo.append(連結);
                }
                if (!RString.isNullOrEmpty(entity.getFujoShuruiCode())
                        && !RString.isNullOrEmpty(CodeMaster.getCodeRyakusho(SubGyomuCode.URZ業務共通_共通系, URZCodeShubetsu.扶助種類コード
                                        .getCodeShubetsu(), new Code(entity.getFujoShuruiCode()), FlexibleDate.getNowDate()))) {
                    codeRyakusho.append(CodeMaster.getCodeRyakusho(SubGyomuCode.URZ業務共通_共通系, URZCodeShubetsu.扶助種類コード
                            .getCodeShubetsu(), new Code(entity.getFujoShuruiCode()), FlexibleDate.getNowDate()));
                    codeRyakusho.append(連結);
                }
                relateEntity.setFujoShuruiCode(shuruiCode.toRString());
                relateEntity.setFujoShurui(codeRyakusho.toRString());
                relateEntity.setJukyuTeishiShuryoYMD(teishiShuryo.toRString());
                relateEntity.setJukyuTeishiKaishiYMD(teishiKaishi.toRString());
                if (!builder.equals(getKiBuilder(entity)) && !RString.isNullOrEmpty(builder)) {
                    list.add(relateEntity2);
                }
                relateEntity2 = relateEntity;
                builder = getKiBuilder(entity);
            }
            list.add(relateEntity2);
            for (SeikatsuhogoRelateEntity busi : list) {
                business.add(new SeikaatsuhogoBusiness(busi));
            }
        }
        return SearchResult.of(business, 0, false);
    }

    private RString getKiBuilder(SeikatsuhogoRelateEntity entity) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(entity.getShikibetsuCode().getColumnValue());
        builder.append(entity.getGyomuCode().getColumnValue());
        builder.append(entity.getJukyuKaishiYMD());
        return builder.toRString();
    }
}
