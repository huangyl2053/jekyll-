/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekiichiran.JukyushaKyufujissekiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran.JukyushaKyufujissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran.JukyushaKyufujissekiIchiranTableEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績一覧表　の給付実績基本 Processクラスです。
 *
 * @reamsid_L DBC-3070-030 dangjingjing
 */
public class SelectKyuhuZissekiKihonJoukenChushutuProcess extends BatchProcessBase<JukyushaKyufujissekiIchiranRelateEntity> {
    
    private static final RString 受給者給付実績 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.jukyushakyufujissekiichiran.IJukyushaKyufujissekiIchiranMapper.get受給者給付実績");
    private JukyushaKyufujissekiIchiranProcessParameter processParamter;
    private static final RString 実績一覧表 = new RString("JukyusyaKyufuJiqsekiIchiranhyouTable");
    private static final RString ゼロ = new RString("0");
    private static final RString いち = new RString("1");
    
    @BatchWriter
    BatchEntityCreatedTempTableWriter 一時実績一覧表;
    
    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        processParamter.setPsmShikibetsuTaisho(new RString(uaFt200Psm.getParameterMap().
                get("psmShikibetsuTaisho").toString()));
        
        List 給付実績区分List = new ArrayList<>();
        if (processParamter.get要介護1().equals(いち)) {
            給付実績区分List.add(new RString("21"));
        }
        if (processParamter.get要介護2().equals(いち)) {
            給付実績区分List.add(new RString("22"));
        }
        if (processParamter.get要介護3().equals(いち)) {
            給付実績区分List.add(new RString("23"));
        }
        if (processParamter.get要介護4().equals(いち)) {
            給付実績区分List.add(new RString("24"));
        }
        if (processParamter.get要介護5().equals(いち)) {
            給付実績区分List.add(new RString("25"));
        }
        if (processParamter.get要支援1().equals(いち)) {
            給付実績区分List.add(new RString("12"));
        }
        if (processParamter.get要支援2().equals(いち)) {
            給付実績区分List.add(new RString("13"));
        }
        if (processParamter.get事業対象者().equals(いち)) {
            給付実績区分List.add(new RString("06"));
        }
        if (processParamter.get経過的要介護().equals(いち)) {
            給付実績区分List.add(new RString("11"));
        }
        if (processParamter.get経過的要介護().equals(いち)) {
            給付実績区分List.add(new RString("01"));
        }
        processParamter.set給付実績区分List(給付実績区分List);
        return new BatchDbReader(受給者給付実績, processParamter.toJukyushaKyufujissekiIchiranMybatisParameter(RString.EMPTY));
    }
    
    @Override
    protected void createWriter() {
        一時実績一覧表 = new BatchEntityCreatedTempTableWriter(実績一覧表,
                JukyushaKyufujissekiIchiranTableEntity.class);
    }
    
    @Override
    protected void process(JukyushaKyufujissekiIchiranRelateEntity entity) {
        if (entity.getYoKaigoJotaiKubunCode() != null && !entity.getYoKaigoJotaiKubunCode().isEmpty()) {
            entity.set要介護状態区分名称(YokaigoJotaiKubunSupport.toValue(new FlexibleDate(entity.getServiceTeikyoYM().concat("01")),
                    new RString(entity.getYoKaigoJotaiKubunCode().toString())).getName());
        }
        if (!entity.getKyufuJissekiKubunCode().isEmpty()) {
            entity.set給付実績区分名称(KyufuJissekiKubun.toValue(entity.getKyufuJissekiKubunCode()).get名称());
        }
        JukyushaKyufujissekiIchiranTableEntity tablEntity = new JukyushaKyufujissekiIchiranTableEntity();
        tablEntity.set入力識別番号(entity.getInputShikibetsuNo());
        tablEntity.set証記載保険者番号(entity.get証記載保険者番号());
        tablEntity.set被保険者番号(entity.getShichosonCode());
        tablEntity.setサービス提供年月(entity.getServiceTeikyoYM());
        tablEntity.set事業所番号(entity.getJigyoshoNo());
        tablEntity.set給付実績区分コード(entity.getKyufuJissekiKubunCode());
        tablEntity.set公費1_負担者番号(entity.get公費1_負担者番号());
        tablEntity.set公費1_受給者番号(entity.get公費1_受給者番号());
        tablEntity.set公費2_負担者番号(entity.get公費2_負担者番号());
        tablEntity.set公費2_受給者番号(entity.get公費2_受給者番号());
        tablEntity.set公費3_負担者番号(entity.get公費3_負担者番号());
        tablEntity.set公費3_受給者番号(entity.get公費3_受給者番号());
        tablEntity.set要介護状態区分コード(entity.getYoKaigoJotaiKubunCode());
        tablEntity.set後_保険_サービス単位数(entity.get後_保険_サービス単位数());
        tablEntity.set後_保険_請求額(entity.get後_保険_請求額());
        tablEntity.set後_保険_利用者負担額(entity.get後_保険_利用者負担額());
        tablEntity.set後_緊急時施設療養費請求額(entity.get後_緊急時施設療養費請求額());
        tablEntity.set後_保険_特定診療費請求額(entity.get後_保険_特定診療費請求額());
        tablEntity.set後_保険_特定入所者介護サービス費等請求額(entity.get後_保険_特定入所者介護サービス費等請求額());
        tablEntity.set後_公費1_サービス単位数(entity.get後_公費1_サービス単位数());
        tablEntity.set後_公費1_請求額(entity.get後_公費1_請求額());
        tablEntity.set後_公費1_本人負担額(entity.get後_公費1_本人負担額());
        tablEntity.set後_公費1_緊急時施設療養費請求額(entity.get後_公費1_緊急時施設療養費請求額());
        tablEntity.set後_公費1_特定診療費請求額(entity.get後_公費1_特定診療費請求額());
        tablEntity.set後_公費1_特定入所者介護サービス費等請求額(entity.get後_公費1_特定入所者介護サービス費等請求額());
        tablEntity.set後_公費2_サービス単位数(entity.get後_公費2_サービス単位数());
        tablEntity.set後_公費2_請求額(entity.get後_公費2_請求額());
        tablEntity.set後_公費2_本人負担額(entity.get後_公費2_本人負担額());
        tablEntity.set後_公費2_緊急時施設療養費請求額(entity.get後_公費2_緊急時施設療養費請求額());
        tablEntity.set後_公費2_特定診療費請求額(entity.get後_公費2_特定診療費請求額());
        tablEntity.set後_公費2_特定入所者介護サービス費等請求額(entity.get後_公費2_特定入所者介護サービス費等請求額());
        tablEntity.set後_公費3_サービス単位数(entity.get後_公費3_サービス単位数());
        tablEntity.set後_公費3_請求額(entity.get後_公費3_請求額());
        tablEntity.set後_公費3_本人負担額(entity.get後_公費3_本人負担額());
        tablEntity.set後_公費3_緊急時施設療養費請求額(entity.get後_公費3_緊急時施設療養費請求額());
        tablEntity.set後_公費3_特定診療費請求額(entity.get後_公費3_特定診療費請求額());
        tablEntity.set後_公費3_特定入所者介護サービス費等請求額(entity.get後_公費3_特定入所者介護サービス費等請求額());
        tablEntity.set審査年月(entity.getShinsaYM());
        tablEntity.set識別コード(entity.get識別コード());
        tablEntity.set市町村コード(entity.getShichosonCode());
        tablEntity.set被保険者氏名(entity.get被保険者氏名());
        tablEntity.set被保険者カナ(entity.getKanaMeisho());
        tablEntity.set住所(entity.get住所());
        tablEntity.set町域コード(entity.getChoikiCode());
        tablEntity.set行政区コード(entity.getGyoseikuCode());
        tablEntity.set世帯コード(entity.getSetaiCode());
        tablEntity.set事業者名称(entity.get事業者名称());
        tablEntity.set要介護状態区分名称(entity.get要介護状態区分名称());
        tablEntity.set給付実績区分名称(entity.get給付実績区分名称());
        tablEntity.set様式(entity.getMeishoCode());
        一時実績一覧表.insert(tablEntity);
    }
}
