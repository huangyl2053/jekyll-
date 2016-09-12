/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokubetsuchoshudoteimidoteiichiran;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 特徴対象者一覧作成のバッチ起動時に設定される<br>
 * 特別徴収同定・未同定一覧表作成パラメータ
 *
 * @reamsid_L DBB-1860-040 pengxingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString shoriNendo;
    private RString kaishuTsuki;
    private List<RString> hosokuTsukiList;
    private RString tsuchiNaiyoCode;

    /**
     *
     * @param shoriNendo 処理年度
     * @param kaishuTsuki 開始月
     * @param hosokuTsukiList 捕捉月リスト
     * @param tsuchiNaiyoCode 通知内容コード
     * @param searchKey 宛名検索条件
     */
    public TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter(RString shoriNendo, RString kaishuTsuki,
            List<RString> hosokuTsukiList, RString tsuchiNaiyoCode, IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.shoriNendo = shoriNendo;
        this.kaishuTsuki = kaishuTsuki;
        this.hosokuTsukiList = hosokuTsukiList;
        this.tsuchiNaiyoCode = tsuchiNaiyoCode;
    }

}
