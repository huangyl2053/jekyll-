/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikenshoget;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT5304ShujiiIkenshoIkenItemMapper;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 完了処理・主治医意見書入手のManagerクラスです。
 *
 * @reamsid_L DBE-0330-010 lishengli
 */
public class IkenshogetManager {

    private final MapperProvider mapperProvider;
    private final DbT5105NinteiKanryoJohoDac dac;

    /**
     * コンストラクタです。
     */
    IkenshogetManager() {
        dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param dac DbT5105NinteiKanryoJohoDac
     */
    IkenshogetManager(MapperProvider mapperProvider,
            DbT5105NinteiKanryoJohoDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IkenshogetManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link IkenshogetManager}のインスタンス
     */
    public static IkenshogetManager createInstance() {
        return InstanceProvider.create(IkenshogetManager.class);
    }

    /**
     * 主キーに合致する要介護認定申請情報を返します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return boolean
     */
    @Transaction
    public boolean 完了処理事前チェック(RString 申請書管理番号) {
        List<RString> 連番List = new ArrayList<>();
        IDbT5304ShujiiIkenshoIkenItemMapper mapper = mapperProvider.create(IDbT5304ShujiiIkenshoIkenItemMapper.class);
        List<DbT5304ShujiiIkenshoIkenItemEntity> entityList = mapper.selectBy申請書管理番号(申請書管理番号);
        if (entityList == null || entityList.isEmpty()) {
            return false;
        }
        for (DbT5304ShujiiIkenshoIkenItemEntity entity : entityList) {
            連番List.add(new RString(entity.getRemban()));
        }
        for (DbT5304ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(getColumnValue(entity.getKoroshoIfShikibetsuCode()))) {
                return 連番List.containsAll(get99A連番List());
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(getColumnValue(entity.getKoroshoIfShikibetsuCode()))) {
                return 連番List.containsAll(get02A連番List());
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(
                    getColumnValue(entity.getKoroshoIfShikibetsuCode()))) {
                return 連番List.containsAll(get06A連番List());
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(getColumnValue(entity.getKoroshoIfShikibetsuCode()))
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(getColumnValue(entity.getKoroshoIfShikibetsuCode()))) {
                return 連番List.containsAll(get09A_09B連番List());
            }
        }
        return true;
    }

    /**
     * 要介護認定完了情報更新処理です。
     *
     * @param 要介護認定完了情報 NinteiKanryoJoho
     * @return int
     */
    @Transaction
    public int 要介護認定完了情報更新(NinteiKanryoJoho 要介護認定完了情報) {
        if (要介護認定完了情報 != null) {
            dac.save(要介護認定完了情報.toEntity());
        }
        return 0;
    }

    private List<RString> get99A連番List() {
        List<RString> list = new ArrayList<>();
        list.add(new RString("15"));
        list.add(new RString("16"));
        list.add(new RString("17"));
        list.add(new RString("18"));
        list.add(new RString("19"));
        return list;
    }

    private List<RString> get02A連番List() {
        List<RString> list = new ArrayList<>();
        list.add(new RString("15"));
        list.add(new RString("16"));
        list.add(new RString("17"));
        list.add(new RString("18"));
        list.add(new RString("19"));
        return list;
    }

    private List<RString> get06A連番List() {
        List<RString> list = new ArrayList<>();
        list.add(new RString("14"));
        list.add(new RString("15"));
        list.add(new RString("16"));
        list.add(new RString("17"));
        list.add(new RString("69"));
        return list;
    }

    private List<RString> get09A_09B連番List() {
        List<RString> list = new ArrayList<>();
        list.add(new RString("14"));
        list.add(new RString("15"));
        list.add(new RString("16"));
        list.add(new RString("17"));
        list.add(new RString("69"));
        return list;
    }

    private RString getColumnValue(Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return code.getColumnValue();
    }
}
