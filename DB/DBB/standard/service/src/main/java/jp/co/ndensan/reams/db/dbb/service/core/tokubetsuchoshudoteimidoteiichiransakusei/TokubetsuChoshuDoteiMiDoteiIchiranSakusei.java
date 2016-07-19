/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokubetsuchoshudoteimidoteiichiransakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiIchiranEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuMidoteiIchiranEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokubetsuchoshudoteimidoteiichiran.ITokubetsuChoshuDoteiMiDoteiIchiranMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 特特別徴収同定・未同定一覧表。
 *
 * @reamsid_L DBB-1860-050 pengxingyi
 */
public class TokubetsuChoshuDoteiMiDoteiIchiranSakusei {

    private final MapperProvider mapperProvider;

    private static final RString TEN = new RString("10");

    /**
     * コンストラクタです。
     */
    public TokubetsuChoshuDoteiMiDoteiIchiranSakusei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 特別徴収同定一覧情報取得です。
     *
     * @param shoriNendo 処理年度
     * @param kaishuTsuki 開始月
     * @param hosokuTsukiList 捕捉月リスト
     * @return {@link List<TokubetsuChoshuDoteiIchiranEntity>}
     */
    public List<TokubetsuChoshuDoteiIchiranEntity> getTokuchoTaishoListJoho(RString shoriNendo,
            RString kaishuTsuki, List<RString> hosokuTsukiList) {
        ITokubetsuChoshuDoteiMiDoteiIchiranMapper mapper = mapperProvider.create(ITokubetsuChoshuDoteiMiDoteiIchiranMapper.class);
        TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter param = getMybatisParameter(shoriNendo, kaishuTsuki, hosokuTsukiList);
        return mapper.get特別徴収同定一覧情報(param);
    }

    /**
     *
     * 特別徴収未同定一覧情報取得です。
     *
     * @param shoriNendo 処理年度
     * @param kaishuTsuki 開始月
     * @param hosokuTsukiList 捕捉月リスト
     * @return {@link List<TokubetsuChoshuMidoteiIchiranEntity>}
     */
    public List<TokubetsuChoshuMidoteiIchiranEntity> getTokuchoMiTaishoListJoho(RString shoriNendo,
            RString kaishuTsuki, List<RString> hosokuTsukiList) {
        ITokubetsuChoshuDoteiMiDoteiIchiranMapper mapper = mapperProvider.create(ITokubetsuChoshuDoteiMiDoteiIchiranMapper.class);
        TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter param = getMybatisParameter(shoriNendo, kaishuTsuki, hosokuTsukiList);
        return mapper.get特別徴収未同定一覧情報(param);
    }

    private TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter getMybatisParameter(RString shoriNendo,
            RString kaishuTsuki, List<RString> hosokuTsukiList) {
        IShikibetsuTaishoPSMSearchKey atenaKey = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).build();
        RString tsuchiNaiyoCode;
        if (TEN.equals(kaishuTsuki)) {
            tsuchiNaiyoCode = TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード();
        } else {
            tsuchiNaiyoCode = TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード();
        }
        return new TokubetsuChoshuDoteiMiDoteiIchiranMybatisParameter(shoriNendo,
                kaishuTsuki, hosokuTsukiList, tsuchiNaiyoCode, atenaKey);
    }

}
