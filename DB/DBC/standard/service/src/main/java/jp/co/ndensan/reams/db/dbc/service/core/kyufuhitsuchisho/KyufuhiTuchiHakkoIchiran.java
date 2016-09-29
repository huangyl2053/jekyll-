/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyufuhitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufuhitsuchisho.KyufuhiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakoichiran.KyufuhiTuchiHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費通知発行一覧表の帳票データを作成するクラスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public class KyufuhiTuchiHakkoIchiran {

    /**
     * コンストラクタです。
     *
     * @param hakkoEntity KyufuhiTuchiHakkoEntity
     * @param processParameter KyufuhiTsuchishoProcessParameter
     * @return 介護保険給付費通知書のEntity
     */
    public KyufuhiTuchiHakkoIchiranEntity 帳票データ作成1(KyufuhiTuchiHakkoEntity hakkoEntity,
            KyufuhiTsuchishoProcessParameter processParameter) {
        KyufuhiTuchiHakkoIchiranEntity coverEntity = new KyufuhiTuchiHakkoIchiranEntity();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        coverEntity.set発行日時(processParameter.get処理年月日());
        coverEntity.set保険者コード(association.getLasdecCode_().value());
        coverEntity.set保険者名(association.get市町村名());
        // TODO 出力順は実装されていない.
        coverEntity.set出力順1(RString.EMPTY);
        coverEntity.set出力順2(RString.EMPTY);
        coverEntity.set出力順3(RString.EMPTY);
        coverEntity.set出力順4(RString.EMPTY);
        coverEntity.set出力順5(RString.EMPTY);
        coverEntity.set改ページ条件1(RString.EMPTY);
        coverEntity.set改ページ条件2(RString.EMPTY);
        coverEntity.set改ページ条件3(RString.EMPTY);
        coverEntity.set改ページ条件4(RString.EMPTY);
        coverEntity.set改ページ条件5(RString.EMPTY);
        coverEntity.set被保険者氏名(new RString("該当データがありません"));
        return coverEntity;
    }

    /**
     * コンストラクタです。
     *
     * @param hakkoEntity KyufuhiTuchiHakkoEntity
     * @param processParameter KyufuhiTsuchishoProcessParameter
     * @return 介護保険給付費通知書のEntity
     */
    public KyufuhiTuchiHakkoIchiranEntity 帳票データ作成2(KyufuhiTuchiHakkoEntity hakkoEntity,
            KyufuhiTsuchishoProcessParameter processParameter) {
        KyufuhiTuchiHakkoIchiranEntity coverEntity = new KyufuhiTuchiHakkoIchiranEntity();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        coverEntity.set発行日時(processParameter.get処理年月日());
        coverEntity.set保険者コード(association.getLasdecCode_().value());
        coverEntity.set保険者名(association.get市町村名());
        // TODO 出力順は実装されていない.
        coverEntity.set出力順1(RString.EMPTY);
        coverEntity.set出力順2(RString.EMPTY);
        coverEntity.set出力順3(RString.EMPTY);
        coverEntity.set出力順4(RString.EMPTY);
        coverEntity.set出力順5(RString.EMPTY);
        coverEntity.set改ページ条件1(RString.EMPTY);
        coverEntity.set改ページ条件2(RString.EMPTY);
        coverEntity.set改ページ条件3(RString.EMPTY);
        coverEntity.set改ページ条件4(RString.EMPTY);
        coverEntity.set改ページ条件5(RString.EMPTY);
        coverEntity.set帳票連番(RString.EMPTY);
        coverEntity.set被保険者氏名(hakkoEntity.get証記載保険者名());
        coverEntity.set被保険者番号(hakkoEntity.get被保険者番号());
        coverEntity.set証記載保険者(hakkoEntity.get証記載保険者番号());
        coverEntity.set年月(hakkoEntity.getサービス提供年月());
        coverEntity.setサービス事業者コード(hakkoEntity.get事業所番号());
        coverEntity.setサービス事業者(hakkoEntity.get事業者名称());
        coverEntity.setサービス種類コード(hakkoEntity.getサービス種類コード());
        coverEntity.setサービス項目コード(hakkoEntity.getサービス項目コード());
        coverEntity.setサービス名称(hakkoEntity.getサービス名称());
        coverEntity.set日数_回数(hakkoEntity.get日数_回数());
        coverEntity.set利用者負担額_円(new RString(hakkoEntity.get利用者負担額().toString()));
        coverEntity.setサービス費用_円(new RString(hakkoEntity.getサービス費用合計額().toString()));
        coverEntity.set要介護度(YokaigoJotaiKubunSupport.toValue(new FlexibleDate(hakkoEntity.getサービス提供年月()),
                hakkoEntity.get要介護状態区分コード()).getName());
        coverEntity.set資格喪失日(hakkoEntity.get資格喪失年月日());
        coverEntity.set喪失事由(ShikakuSoshitsuJiyu.toValue(hakkoEntity.get資格喪失事由コード()).get名称());
        if (0 < hakkoEntity.get利用者負担額().compareTo(Decimal.ZERO) || 0 < hakkoEntity.getサービス費用合計額().compareTo(Decimal.ZERO)) {
            coverEntity.set補正有無(new RString("※"));
        }
        return coverEntity;
    }
}
