/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigyobunkogakugassanshikyukettei;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_事業分高額合算支給決定情報のMybatis用パラメータクラスです。
 *
 * @reamsid_L DBC-5060-030 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class JigyoBunKogakuGassanShikyuKetteiMybatisParameter implements IMyBatisParameter {

    private final RString 保険者コード;
    private final boolean is保険者コード;
    private final RString 対象年度;
    private final boolean is対象年度NULL;
    private final RString 支給区分;
    private final RString 支払方法区分;
    private final RString 金融機関コード;
    private final boolean is金融機関コードNULL;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;
    private final IKozaSearchKey key;

    /**
     * コンストラクタです。
     */
    private JigyoBunKogakuGassanShikyuKetteiMybatisParameter(
            RString 保険者コード,
            boolean is保険者コード,
            RString 対象年度,
            boolean is対象年度NULL,
            RString 支給区分,
            RString 支払方法区分,
            RString 金融機関コード,
            boolean is金融機関コードNULL,
            RString psmShikibetsuTaisho,
            RString psmAtesaki,
            IKozaSearchKey key) {
        this.保険者コード = 保険者コード;
        this.is保険者コード = is保険者コード;
        this.対象年度 = 対象年度;
        this.is対象年度NULL = is対象年度NULL;
        this.支給区分 = 支給区分;
        this.支払方法区分 = 支払方法区分;
        this.金融機関コード = 金融機関コード;
        this.is金融機関コードNULL = is金融機関コードNULL;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
        this.key = key;
    }

    /**
     * MybatisParameterの作成です。
     *
     * @param 保険者コード 保険者コード
     * @param 支給区分 支給区分
     * @param 支払方法区分 支払方法区分
     * @param 金融機関コード 金融機関コード
     * @param 対象年度 対象年度
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmAtesaki psmAtesaki
     * @param key key
     * @return JigyoBunKogakuGassanShikyuKetteiMybatisParameter
     */
    public static JigyoBunKogakuGassanShikyuKetteiMybatisParameter createMybatisParameter(RString 保険者コード,
            RString 対象年度,
            RString 支給区分,
            RString 支払方法区分,
            RString 金融機関コード,
            RString psmShikibetsuTaisho,
            RString psmAtesaki,
            IKozaSearchKey key) {
        boolean is保険者コード = false;
        if (!RString.isNullOrEmpty(保険者コード) && !new RString("000000").equals(保険者コード)) {
            is保険者コード = true;
        }

        return new JigyoBunKogakuGassanShikyuKetteiMybatisParameter(保険者コード,
                is保険者コード,
                対象年度,
                isnull(対象年度),
                支給区分,
                支払方法区分,
                金融機関コード,
                isnull(金融機関コード),
                psmShikibetsuTaisho,
                psmAtesaki,
                key);
    }

    private static boolean isnull(RString value) {
        boolean flag = false;
        if (RString.isNullOrEmpty(value)) {
            flag = true;
        }
        return flag;
    }
}
