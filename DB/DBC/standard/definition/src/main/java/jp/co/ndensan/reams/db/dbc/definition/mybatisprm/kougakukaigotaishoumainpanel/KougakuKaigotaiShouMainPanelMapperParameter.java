/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakukaigotaishoumainpanel;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額介護対象者抽出（遡及分）パラメタクラです。
 *
 * @reamsid_L DBC-5750-010 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class KougakuKaigotaiShouMainPanelMapperParameter {

    private final RString サブ業務コード;
    private final RString 市町村コード;
    private final RString 処理名;
    private final RString 年度;
    private final RString 年度内連番;
    private final RString 処理枝番;
    private final RString 処理状態区分;
    private final RString 交換情報識別番号;

    private KougakuKaigotaiShouMainPanelMapperParameter(RString サブ業務コード,
            RString 市町村コード,
            RString 処理名,
            RString 年度,
            RString 年度内連番,
            RString 処理枝番,
            RString 処理状態区分,
            RString 交換情報識別番号) {
        this.サブ業務コード = サブ業務コード;
        this.市町村コード = 市町村コード;
        this.処理名 = 処理名;
        this.年度 = 年度;
        this.年度内連番 = 年度内連番;
        this.処理枝番 = 処理枝番;
        this.処理状態区分 = 処理状態区分;
        this.交換情報識別番号 = 交換情報識別番号;
    }

    /**
     * 高額介護対象者抽出検索用のパラメータを生成します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 市町村コード 市町村コード
     * @param 処理名 処理名
     * @param 年度 年度
     * @param 年度内連番 年度内連番
     * @param 処理枝番 処理枝番
     * @param 処理状態区分 処理状態区分
     * @param 交換情報識別番号 交換情報識別番号
     * @return KougakuKaigotaiShouMainPanelMapperParameter
     */
    public static KougakuKaigotaiShouMainPanelMapperParameter createSelectListParam(RString サブ業務コード,
            RString 市町村コード,
            RString 処理名,
            RString 年度,
            RString 年度内連番,
            RString 処理枝番,
            RString 処理状態区分,
            RString 交換情報識別番号) {
        return new KougakuKaigotaiShouMainPanelMapperParameter(サブ業務コード,
                市町村コード,
                処理名,
                年度,
                年度内連番,
                処理枝番,
                処理状態区分,
                交換情報識別番号);
    }
}
